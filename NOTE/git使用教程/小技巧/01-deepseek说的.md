先说结论：**Git 本身没有"业务用法"这回事，业务用法 = 团队为了不互相踩脚而约定的一套规矩。**你现在的用法（本地提交 → push 到 GitHub）就是"单人模式"，团队模式的全部复杂度都来自于**多个人同时改一个仓库**。我把这套规矩给你拆开讲。

---

## 1. 先纠正一个概念：分支根本不"重"

很多人怕分支，是以为创建分支像"复制一份代码"。不是的。

分支在 Git 里就是**一个写着 commit 哈希值的小文件**（存在 `.git/refs/heads/` 下）。创建分支 = 写一个 41 字节的文件，瞬间完成，跟代码量无关。

```
         C1 --- C2 --- C3   ← main（这个"指针"现在指向 C3）
                       \
                        C4 --- C5   ← feature/login（指向 C5）
```

- **HEAD** 是"你现在站在哪"的指针，通常指向某个分支名。
- `git switch -c feature/login` = 新建一个指针 + 把 HEAD 挪过去。
- 你每次 `git commit`，Git 就是**把当前分支指针往前挪一格**。

一句话：**分支 = 一条可移动的书签，指向一条提交链。**所以业务上可以放心地一人一分支、一功能一分支。

另外你现在的常用操作里，`git checkout` 这个老命令把"切分支"和"恢复文件"两件事混在一起了，新版本拆成了：

| 老写法 | 新写法（推荐） |
|---|---|
| `git checkout main` | `git switch main` |
| `git checkout -b xxx` | `git switch -c xxx` |
| `git checkout -- file` | `git restore file` |

---

## 2. master 和 main 到底啥区别

**没有任何技术区别，纯改名。**历史原因是 Git 默认分支叫 `master`，2020 年 GitHub 出于"master/slave"用词敏感的考虑，把新建仓库的默认分支改成了 `main`。Git 2.28 也跟着支持配置默认名。

现状：
- 老仓库：多半还叫 `master`（你 Gitee 上的仓库大概率是）
- 新仓库：叫 `main`
- 有些公司：`trunk`、`develop`、`prod`

它就是个**普通分支名**，只是团队约定把它当"主线/主干的唯一真源（single source of truth）"。

改名（可选，改完本地还要同步远端）：

```bash
git branch -m master main          # 本地改名
git push -u origin main            # 推上去
git push origin --delete master    # 删远端旧的（小心，先确认保护规则已关）
```

**别纠结这个名字，团队里叫什么都行，重点是下面这条纪律。**

---

## 3. 业务里最核心的纪律（记住这三条，你就超过一半新人）

> 1. **main（或 master）永远是"可发布状态"**——能编译、能跑、随时能上线。
> 2. **任何人不能直接往 main 上提交**（哪怕你有权限）。一律走分支 + 合并请求。
> 3. **一条分支只干一件事**，名字要能看出来干了啥。

你现在应该是直接 `git push origin main`，这就是典型的单人做法。团队里这么干，第二天你就会把同事没测完的代码带上线。

---

## 4. 完整日常流程（Feature Branch 工作流）

这是 90% 公司实际在用的模式：

```bash
# ① 从最新的 main 切出一条分支（每次开工前先同步！）
git switch main
git pull                          # 等于 fetch + merge
git switch -c feature/user-login

# ② 干活，小步提交
git add -p                        # 逐块挑选改动，比 git add . 干净得多
git commit -m "feat: 增加用户登录接口"

# ③ 推到自己分支（第一次要 -u 建立跟踪关系）
git push -u origin feature/user-login

# ④ 到 GitHub/Gitee 上开 Pull Request（Gitee 叫 Pull Request，GitLab 叫 Merge Request，同一个东西）

# ⑤ 同事 review → 可能让你改 → 你在同一条分支继续 commit + push，PR 会自动更新
# ⑥ CI（自动测试）跑绿 → 点 Merge → 分支可以删掉

# ⑦ 回到本地收尾
git switch main
git pull
git branch -d feature/user-login      # 删本地分支
git push origin --delete feature/user-login   # 删远端分支
```

**关键点：`git pull` 之前先切到 main。**新人最常见的错误是：在 feature 分支上 `git pull`，把别人的提交合进自己的分支，然后 PR 里冒出一堆不是自己改的文件。

### `git fetch` vs `git pull`

- `git fetch` = 只把远端的更新下载到本地的 `origin/main` 指针，**不动你的工作区**。
- `git pull` = `git fetch` + `git merge`，会真的改你的文件。

想看远端有啥新东西又不想被打扰，就 `git fetch` 然后 `git log main..origin/main`。团队里推荐养成"先 fetch 看看"的习惯。

---

## 5. 代码是怎么合进 main 的（三种策略）

点 PR 上那个绿色 Merge 按钮时，背后有三种玩法，公司会选一种：

| 策略 | 效果 | 特点 |
|---|---|---|
| **Merge commit** | main 上多一个"合并节点" | 保留完整历史，能看到"这批改动是一个功能"，但线会乱 |
| **Squash and merge** | 你分支上的 20 个 commit 被压成 1 个塞进 main | **国内公司最常用**，main 历史极干净，但丢失过程记录 |
| **Rebase and merge** | 把你的 commit 一个个"搬"到 main 顶端 | 完全线性，看不到分支痕迹 |

新手建议：**跟着团队选，一般就是 Squash。**如果 PR 里你提交了 20 次 "fix typo"，Squash 会帮你救回来。

---

## 6. merge 和 rebase 的区别（面试和实操都会被问）

同样是"把我的分支和 main 同步"，两种做法：

**merge**：造一个新 commit，把两条线接到一起
```
main:    A --- B --- C ------- M
                   \         /
feature:            D --- E
```

**rebase**：把你的 D、E 拆下来，在 C 后面重新"贴"一遍（commit 哈希值会变，等于重写了历史）
```
main:    A --- B --- C --- D' --- E'
```

铁律：

> **只在"自己的、没别人用的"分支上 rebase。已经推到远端、别人可能基于它干活的分支，绝对不许 rebase。**

所以常见组合是：

```bash
git switch feature/user-login
git fetch origin
git rebase origin/main       # 用最新的 main 垫在自己下面，保持自己的分支线性
# 有冲突就解决，然后：
git add <冲突文件>
git rebase --continue        # 想放弃就 git rebase --abort
```

用 rebase 同步主干的理由：否则你 PR 里会混进一堆"Merge branch 'main' into feature"的噪音 commit。

> 顺带说：**操作前不确定就先开一条备份分支**（`git branch backup-xxx`）。有备份，任何"搞砸了"都能救回来。Git 几乎不丢数据，怕的是你不知道丢哪了。

---

## 7. 真实的业务分支模型（长啥样）

**大厂主干开发（Trunk Based）**——现在最主流：

```
main                    ← 永远可发布，随时能上生产
 ├── feature/xxx        ← 活几小时到几天
 ├── fix/xxx
 └── chore/xxx
```

配**"发布分支"或者干脆"打 tag 发布"**：

```bash
git tag -a v1.4.0 -m "1.4.0 上线"     # 给某个 commit 打个不可变的版本标记
git push origin v1.4.0
```

**经典 Git Flow**（老项目、有明确版本周期的客户端/嵌入式常见）：

```
main       ← 只放已上线的版本，每次合并都打 tag
hotfix/*   ← 线上出 bug，从 main 拉出来紧急修，修完合回 main 和 develop
develop    ← 日常集成分支，功能都合到这里
feature/*  ← 从 develop 拉
release/*  ← 发布前从 develop 拉，只修 bug 不加功能
```

Git Flow 分支多、心智负担重，很多团队已经不用了。但你要是进一家做客户端/私有化部署的公司，可能还是会遇到。**不用背，知道有这回事就行。**

**环境分支**这套在国内也很常见：

```
main  →  测试环境自动部署
uat   →  预发环境
prod  →  生产环境（要审批才能合）
```

---

## 8. commit message 规范（Conventional Commits）

团队一般会强制（有 CI 检查，写错不让合）。格式：

```
<类型>(<范围>): <描述>

feat(user): 增加手机号登录
fix(order): 修复优惠券重复抵扣
docs: 更新部署说明
refactor: 拆分支付模块
test: 补充订单单测
chore: 升级依赖
```

**为什么业务上认真管这个？**因为要自动生成 changelog、自动决定版本号、出线上问题时能 `git log` 快速定位。写"update"、"改了下"、"111"会在 review 时被打回。

一个能省事的配置，让 `git pull` 自动用 rebase、自动清理已删除的远端分支：

```bash
git config --global pull.rebase true
git config --global fetch.prune true
git config --global rebase.autoStash true
```

---

## 9. 业务里天天遇到的麻烦事

**冲突（conflict）**——两个人都改了同一行才会冲突。Git 会在文件里插标记：

```
<<<<<<< HEAD
你这边的内容
=======
别人的内容
>>>>>>> feature/other
```

手工改成你要的最终样子，**把 `<<<` `===` `>>>` 三行标记全删掉**，然后 `git add` + `git commit`（rebase 状态下用 `git rebase --continue`）。

**"我改了个东西，但线上那份不是我发的"** → 查是谁改的：

```bash
git log -p -- path/to/file      # 这个文件的改动历史
git blame path/to/file          # 每一行是谁、哪个 commit 写的
git log --oneline --graph --all # 总览所有分支的拓扑
git show <commit>               # 看某个 commit 具体改了啥
```

**"我提交错了/提交到 main 了"**：

```bash
git reset --soft HEAD~1     # 撤销最后一次 commit，改动还在暂存区（安全）
git commit --amend          # 修改最后一次 commit（**只在没 push 前用！**）
git revert <commit>         # 已经 push 了怎么办？用它造一个"反向提交"，不用改历史（团队安全做法）
```

**急事插队**：手上功能没写完，突然要修线上 bug：

```bash
git stash push -m "登录做到一半"    # 把半成品收起来
git switch main && git pull
git switch -c hotfix/pay-error
# 修完、发 PR、合并
git switch feature/user-login
git stash pop                      # 把半成品拿回来
```

---

## 10. GitHub 上那些按钮是干嘛的（业务含义）

| 功能 | 业务作用 |
|---|---|
| **Branch protection rule** | 禁止直接 push main、必须 PR、必须 N 人 review、必须 CI 通过才能合。**这是团队纪律的技术兜底** |
| **CODEOWNERS** | 指定某目录必须由谁 review（比如 `src/pay/` 必须支付组的人点头） |
| **Draft PR** | 还没写完先开着，告诉同事"别急，还在改" |
| **CI / GitHub Actions** | 每次 PR 自动跑 lint + 测试，红了不许合 |
| **.gitignore** | 别把 `node_modules/`、`.env`、`dist/`、密钥提交进去 |

---

## 你现在该做什么（最小升级路径）

1. 把 `git checkout` 换成 `git switch`。
2. 下次改东西，**别直接推 main**，先 `git switch -c feature/xxx`，推上去开 PR，自己 review 一遍再合。
3. 养成"动 main 之前先切 main 再 pull"。
4. 在 GitHub 仓库 Settings → Branches 里给 main 加一条保护规则（禁止直接 push），逼自己走 PR。
5. commit message 开始用 `feat:` / `fix:` 前缀。

先按这 5 条做两个月，`develop`、`release`、`rebase` 这些你会自己就懂了。

---

要不要我**在你当前工作目录里建一个演示仓库，把整套流程跑一遍给你看**？我会真实地创建分支、制造一次冲突、演示 merge vs rebase 的区别，再用 `git log --graph` 把结果画出来——比看文字直观得多。跑完删掉或者留着都行。