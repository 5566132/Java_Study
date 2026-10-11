# Agent 学习笔记

> 归属：[[13-AI-Agent学习规划]]（学习计划）· `SpringBoot_Note/进度追踪.md`（进度台账）
> 定位：**后端主线的增强线**，不是第二主线。每周 2-3h。

---

## 目录结构

```
Agent_Note/
├── 00-认知/          ← 第 1 层：不写代码，搞懂概念（2026-10 底做）
│   ├── 01-workflow和agent的区别.md
│   ├── 02-prompt基础.md
│   └── 03-第一次调API.md
├── 01-SpringAI/      ← 第 2 层：Java 实现 Function Calling（2027-01）
├── 02-RAG/           ← 第 3 层：检索增强 + 语义缓存（2027-05）
└── 03-工程化/        ← 第 4 层：限流 / 成本 / 可观测性 / MCP（2027-06）
```

---

## 写笔记的规矩（和 Java 笔记一致）

1. **记"我做了什么 / 为什么"**，不是"我看了什么"
2. **代码原样贴，但 key 一律用 `***` 代替**
3. 每篇结尾写一句"**这个知识点我项目里用在哪**"——没有就想想怎么用上
4. 概念性内容标 🔴必会 / 🟡加分 / ⚪了解

---

## 全局提醒

- 🔴 **API key 绝不能进 Git**。存环境变量，别写死在代码里
- 🔴 **控制台设消费限额**。agent 死循环能一夜烧掉几百块
- 🔴 **先裸调 HTTP，再上框架**。跳过这一步，后面框架报错你完全看不懂
- 🟡 **别一上来啃 LangChain / Spring AI 源码**
- 🟡 **别盲目追求多智能体**。能用 workflow 解决就别上 agent（Anthropic 的核心建议）

---

## 快速索引（各阶段入口）

| 阶段 | 去哪学 | 笔记放哪 |
|---|---|---|
| 认知 | [Anthropic《Building Effective Agents》](https://www.anthropic.com/engineering/building-effective-agents) + [DeepLearning.AI Prompt 课](https://www.deeplearning.ai/courses/chatgpt-prompt-eng) | `00-认知/` |
| 上手 | [Spring AI 官方文档](https://docs.spring.io/spring-ai/reference/) | `01-SpringAI/` |
| RAG | [黑马《大模型 RAG 与 Agent》](https://www.bilibili.com/video/BV1yjz5BLEoY/) | `02-RAG/` |
| 工程化 | [MCP 规范](https://modelcontextprotocol.io/) + [Langfuse](https://langfuse.com/docs) | `03-工程化/` |
