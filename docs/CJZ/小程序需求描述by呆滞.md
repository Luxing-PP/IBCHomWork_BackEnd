姑且按软工二规格写了：

PS：

**Optional 标签代表优先级低**

**Technique 标签代表个人的技术上可否实现的疑问**



业务需求：

SF1:  实现对整个程序（数据库）的存活倒计时，可以通过发帖/跟帖可增加时长，倒计时归零重置小程序

SF2:  提供一套完整的轻量化发帖+（伪）随机看贴跟帖机制

SF3: (Option) 实现美观性/个性化需求



对应(也许很)详细描述：

SF1：

- 用户发帖/跟贴可以增加计时器的时长

- 无事发生时按正常时间流逝

- （Optional）

  - 理由：营造紧张感
  - 对应剩余时间长短，计时器（甚至系统UI）UI发生变化

- 首页展示，此次程序存活时长，中间毁灭过几次，以一个（定长/滚动？）列表展示前几次的存活时长

- （Optional）是否可以有每日只要登录了就可以加一点时长（毕竟可能有人只想旁观）

  

SF2：

- 主页选择写可以直接编辑，然后写....（没什么好说的）
- 主页选择读会随机获取一份**已有的**帖子，获取后可以选择直接丢弃看下一篇，也可以进行跟帖
- （Optional）设计灰字提示\发帖指南来引导用户不要水贴【初次使用弹出、或者做成一个可点的按钮】
  - Ex.
    - （引导）
      - 虽然你可能心情很差，但地图炮还是不好哦doge
      - XXXX的内容也没有关系
    - （拒水）
      - “（小程序名）想要轰轰烈烈的一生，无论是活着，还是死去”
- （Optional）
  - 每篇帖子展示一个ID，和创建时间，同时如果这篇帖子该用户曾经参与过做出提醒（UI样式更改/或者之间加一行小字）
- （Optional）
  - 理由：虽然程序明面上卖纯随机的这个点，但用户多多少少还是会希望和自己曾经帖子相遇
  - 描述：将用户参与过的帖子和没参与悄悄分装到两个篮子，通过“某种机制”让用户能维持在一个偶尔能看到自己参与过帖子的频率【真随机的体验很烂啦（抽卡沉池）】



SF4：

- （Optional）在一个类似个人中心的地方，记录用户(指该个体)让这个网站多存续了多久
- （Optional）可更换的页面背景、字体样式、etc



技术面的一些疑惑：

1. （Technique）计时实现是一次同步？
2. （Technique）怎么搞到常规的文本编辑器 （加粗分割线...应该有现成的？）