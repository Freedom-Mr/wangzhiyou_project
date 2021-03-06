#建造者模式
建造者模式（Builder Pattern）使用多个简单的对象一步一步构建成一个复杂的对象。这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。

一个 Builder 类会一步一步构造最终的对象。该 Builder 类是独立于其他对象的。

意图：将一个复杂的构建与其表示相分离，使得同样的构建过程可以创建不同的表示。

应用实例： 
1. 去肯德基，汉堡、可乐、薯条、炸鸡翅等是不变的，而其组合是经常变化的，生成出所谓的"套餐"。 
2. JAVA 中的 StringBuilder。

优点： 
1. 建造者独立，易扩展。 
2. 便于控制细节风险。

缺点： 
1. 产品必须有共同点，范围有限制。 
2. 如内部变化复杂，会有很多的建造类。

使用场景： 
1. 需要生成的对象具有复杂的内部结构。 
2. 需要生成的对象内部属性本身相互依赖。

注意事项：与工厂模式的区别是：建造者模式更加关注与零件装配的顺序。

#工厂模式的实现方式
FactoryPatternDemo 类