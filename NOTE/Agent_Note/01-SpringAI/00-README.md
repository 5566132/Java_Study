# 01 · Spring AI（Function Calling 上手层）

> 📅 阶段：第 2 层 上手 ｜ ⏱ 20-25h ｜ 📅 2027-01
> 📖 主资源：[Spring AI 官方文档](https://docs.spring.io/spring-ai/reference/)（1.0 已于 2025-05 GA）
> 🎯 产出：挂在**苍穹外卖**上的智能客服

---

## 学习清单

- [ ] 加依赖：`spring-ai-openai-spring-boot-starter`（DeepSeek 兼容 OpenAI 格式，改 base-url 即可）
- [ ] 配置：`application.yml` 里配 `api-key` 和 `base-url`
- [ ] **`ChatClient` 基础调用**（对应认知层的 curl，只是换成 Java 写法）
- [ ] **结构化输出**：`.entity(SomeClass.class)` —— 让模型返回 Java 对象
- [ ] 🔴 **Function Calling**：`@Tool` 注解把 Service 方法暴露给模型
- [ ] 流式输出：`Flux<String>`（SSE）
- [ ] 会话持久化：存 MySQL / Redis（复用已有技能）
- [ ] 🟡 Python 最小可用：函数 / 类 / 装饰器 / async / venv

---

## 🔴 硬约束（写在最前面，别忘）

1. **只暴露只读方法**——方法名带 `query`/`get` 前缀，绝不暴露 `deleteOrder`
2. **方法内部必须校验参数**——模型生成的参数不可信，绝不拼 SQL
3. **必须加限流 + 控制台消费限额**

---

## 笔记

### 2027-01-__ 热身：20 分钟跑通"模型调用我的代码"

- 写的 `@Tool` 方法：
- 模型的回答：
- **原来就这么回事** —— 我的感受：

### 2027-01-__ 正式：智能客服

- 暴露的方法：
- 遇到的问题：
- 限流怎么加的：

---

## 面试话术（背下来）

> "我做了 **Function Calling** 的落地，并且评估后**故意没上 agent**——单轮查询已满足需求，上 agent 会引入不确定性、更难调试、还更贵。"

**为什么这句话加分**：它证明我有设计判断力，不是堆技术点。
