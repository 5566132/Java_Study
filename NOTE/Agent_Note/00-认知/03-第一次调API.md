# 第一次调 API（curl 调通 DeepSeek）

> 📅 阶段：第 1 层 认知 ｜ ⏱ 1 小时 + 30 分钟写笔记
> 📖 完整操作步骤见 [[13-AI-Agent学习规划]] 第二节「步骤 3-4」
> ✍️ 这篇是我的**实证记录**：证明我亲手调通过，而不是"我看过教程"

---

## 一、准备工作

- [ ] 注册 https://platform.deepseek.com/
- [ ] 创建 API key，**只显示一次，已保存到安全的地方**
- [ ] 充值 10 元
- [ ] **设置消费限额**（金额：______ 元/月）← 防死循环烧钱，必做
- [ ] key 存进环境变量：`setx DEEPSEEK_API_KEY "sk-..."`
- [ ] 重开终端，`$env:DEEPSEEK_API_KEY` 能打印出来（**打印出来时 key 用 *** 代替记在这里**）

---

## 二、🔴 我跑通的命令（原样贴，key 打码）

```powershell
$body = @'
{
  "model": "deepseek-chat",
  "messages": [
    {"role": "system", "content": "你是一个简洁的助手，回答不超过20个字。"},
    {"role": "user", "content": "用一句话解释什么是 API"}
  ],
  "stream": false
}
'@

curl.exe -s -X POST "https://api.deepseek.com/chat/completions" `
  -H "Content-Type: application/json" `
  -H "Authorization: Bearer ***" `
  -d $body
```

**实际返回**（贴关键部分）：

```json
（粘贴你的真实返回）
```

**发生时间**：____________
**花了多少 token**：prompt = ______ ｜ completion = ______

---

## 三、返回字段的含义（🔴 面试和调试都要懂）

| 字段 | 含义 |
|---|---|
| `choices[0].message.content` | |
| `choices[0].finish_reason` | |
| `usage.prompt_tokens` | |
| `usage.completion_tokens` | |
| `usage.total_tokens` | |

**为什么 completion_tokens 比 prompt_tokens 贵？**
>

---

## 四、5 个实验的结果

### ① System prompt 的作用
>

### ② CoT 的作用（对比有无"请一步步思考"）
>

### ③ 结构化输出稳不稳
>

### ④ Token 计费怎么变（输入变长时）
>

### ⑤ 🔴 **幻觉**（问它不可能知道的事）

我问的是：
>

它回答：
>

**它编了吗？**（这句话很重要，照实写）
>

---

## 五、🔴 实验⑤ 的结论（这篇笔记最重要的一段）

模型会一本正经地编造，所以：

- **需要 RAG** → 给它真资料，让它基于资料回答
- **需要 Function Calling** → 让它去查真数据库，而不是靠记忆猜

> 换句话说：**第 2、3 层要学的东西，就是为了解决我在这里亲眼看到的问题。**
>
> 我的延伸思考：
>

---

## 六、踩坑记录

| 现象 | 原因 | 怎么解决 |
|---|---|---|
| | | |

---

## 七、这个知识点我项目里用在哪

>
