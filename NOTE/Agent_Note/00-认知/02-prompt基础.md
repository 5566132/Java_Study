# Prompt 基础（System / Few-shot / CoT）

> 📅 阶段：第 1 层 认知 ｜ ⏱ 2 小时
> 📖 来源：《ChatGPT Prompt Engineering for Developers》 https://www.deeplearning.ai/courses/chatgpt-prompt-eng
> ✍️ 写完这篇的标准：你能说出"为什么给模型一个角色设定，输出风格会不一样"

---

## 一、两个原则（课程原文 + 我的理解）

### 原则 1 · Write clear and specific instructions（把话说清楚）

课程给的技巧：
- 用**分隔符**把指令和内容分开（```、"""、---）
- 要求**结构化输出**（JSON / HTML）
- 要求**检查前提条件**（"如果条件不满足就回答'无法回答'"）
- **Few-shot**：给几个例子

我的理解：
>

### 原则 2 · Give the model time to think（让它有时间想）

- **Chain of Thought（CoT）**：要求"一步步思考"
- 为什么有效：
>

---

## 二、我的实验记录（🔴 亲手做，别只看）

### 实验 A · System prompt 的作用

| 项 | 内容 |
|---|---|
| System 设定 | |
| User 问题（固定） | |
| 回答 1（无 system / 普通） | |
| 回答 2（有 system） | |
| **结论** | |

### 实验 B · CoT 的效果

题目：一个班 30 人，60% 是女生，女生里 1/3 戴眼镜，戴眼镜的女生几人？

| 版本 | 提问方式 | 模型回答 | 对不对 |
|---|---|---|---|
| 无 CoT | 直接问 | | |
| 有 CoT | 加了"请一步步思考" | | |

**结论**：
>

### 实验 C · 结构化输出稳不稳

| 要求 | 实际返回 | 稳定吗 |
|---|---|---|
| "用 JSON 返回，字段 name / age" | | |

**结论**：
>

---

## 三、消息角色（Role）的区别

| 角色 | 作用 | 什么时候用 |
|---|---|---|
| `system` | | |
| `user` | | |
| `assistant` | | |

---

## 四、⚠️ 注意

课程代码用的是 OpenAI API，**我没注册 OpenAI**——只看思路，动手用 DeepSeek 做（见 `03-第一次调API.md`）。

---

## 五、这个知识点我项目里用在哪

>
