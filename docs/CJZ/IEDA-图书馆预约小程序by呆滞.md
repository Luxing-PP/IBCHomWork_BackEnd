“介绍文档：综合描述作品情况，突出作品的创新点和优势，内容应包括但不限 于小程序说明、应用场景、解决的实际问题、产品设计、技术实现方案（包括 小程序端和后台服务器端）等”（**摘自比赛说明**）



应用场景：对大部分人来说，图书馆的使用只是一天中的几个小时，但图书馆的特点又导致如果不能早早去占座，很可能没有座位。进而为前往图书馆学习这件事蒙上一层“不确定性”的阴影，同时也加剧了可能对恶性占座问题。同时也可以一定程度上替代目前离散存在的互助群。



功能，即本程序旨在：

1. 通过调用南京大学官方在馆人数API并与历史水平对比，提供一个**直观的图书馆现在人数多疏**的提示
2. 建立一套“悬赏预约 --- 应答悬赏”的预约系统
   - 欲前往图书馆的用户可以发出一个悬赏
     包含自己到达时间（和可能的“区域座位要求”，“备注”，“悬赏物资”等）[需要提前到达]
   - 将要结束图书馆使用的用户可以应答悬赏
   - 在系统之上建立起一套虚拟货币体系，作为参与双方的激励
     - 可以由此**延伸**一套除了图书馆座位预约之外的**其他生活服务**（快递/外卖代取）【】
     - 当然也可以直接用小额现金支付取代复杂虚拟货币体系
     - 虚拟货币到达一定数值可以换取尊贵的高级用户标识（以及对应的特权）
     - 双方一方不守信时扣除一定货币作为惩罚机制
     - 官方礼品周边etc（反正虚拟货币这套系统很成熟，去网上抄抄即可（雾））
   - 也可以搞个（本周善事）排行榜满足下lyk的精神需求doge



对应简单UI描述：

1. 首页，就显示一个在馆人数，一个纯美工的几乎静态页面
2. 悬赏栏，构想上类似帖子吧，反正一个状态栏（设置排列顺序检索顺序之类的）+一个滚动窗口里面塞一堆东西呗，很经典又普通的设计
3. 个人中心，更没啥好说的

呜呜呜我是屑，想不出什么有特色的UI，图也懒得画了

