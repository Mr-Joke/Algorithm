## 动态规划法

- **参考文献：《算法设计与分析(第２版)》**

### 1.概述

- **动态规划**(dynamic programming)是在２０世纪５０年代由美国数学家贝尔曼(Richard Bellman)为研究最优控制问题而提出的，programming的含义是计划和规划的意思。动态规划作为一种工具在应用数学中的价值被大家认同以后，在计算机科学界，动态规划法成为一种通用的算法设计技术用来求解多阶段决策最优化问题。

#### 1.1动态规划法的设计思想

- 动态规划法将待求解问题分解成若干个互相重叠的子问题，每个子问题对应决策过程的一个阶段，一般来说，子问题的重叠关系表现在对给定问题求解的递推关系（称为动态规划函数）中，将子问题的解求解一次并填入表中，当需要再次求解此子问题时，可以通过查表获得该子问题的解，从而避免大量重复计算。具体的动态规划法多种多样，但都具有相同的填表形式。一般来说，动态规划法的求解过程由以下三个阶段组成：
  1. 划分子问题：将原问题分解为若干个子问题，每个子问题对应一个决策阶段，并且子问题之间具有重叠关系。
  2. 确定动态规划函数：根据子问题之间的重叠关系找到子问题满足的递推关系式（即动态规划函数），这是动态规划的关键。
  3. 填写表格：设计表格，以自底向上的方式计算各个子问题的解并填表，实现动态规划过程。

### 2.常见问题

#### 2.1图问题中的动态规划

- [多段图的最短路径问题](https://github.com/Mr-Joke/Algorithm/blob/master/Dynamic/src/MSGSPP.java)
  - [求解思路](https://github.com/Mr-Joke/Algorithm/blob/master/Dynamic/docs/MSGSPP.md)

#### 2.2其他问题

- [数塔问题](https://github.com/Mr-Joke/Algorithm/blob/master/Dynamic/src/DataTower.java)
  - [求解思路](https://github.com/Mr-Joke/Algorithm/blob/master/Dynamic/docs/DataTower.md)
