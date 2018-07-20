# RESTFul-API
基于Spring Boot 2.0.3的RESTFul API

pojo分层说明：（和阿里java规约有些不一样）
DTO:  用于前端和后端进行交互的传输对象
PO:   数据库持久化对象，和数据库表结构一一对应
QO:   数据查询对象，用于DAO层作为传入参数
RO:   结果集对象，用于对DAO层查询出来的对象进行封装，也可以省略，直接用PO封装
BO:   业务对象，Service层统一传入的对象
AO:   应用层对象，和VO较为类似，可以省略，service层可以直接返回VO对象
VO:   值对象（显示层对象），用于后端向前端返回的用于模板渲染的对象

先这样初步定义，根据项目进度考虑这样分层是否合适，后面项目再改进


需要注意一点，java8（servlet3）中的接口已经可以有默认方法了，比如spring的WebMvcConfigurer，我也是在实现这个类的时候发现没有实现接口的方法竟然没有报错，点进去看了一下


微服务之间的调用restTemplate必须强制使用httpclient的连接池，并且必须设计超时时间
连接池有两种思路：
1.针对每个第三方服务建立一个连接池
2.针对所有对三方服务建立一个连接池，httpclient4.5好像针对每个路由都可以有一个连接数
建议采用第一种思路

试一下@pathvariale和@requestbody一起使用，这个是跟httpmessageconverter密切相关的

要把auth和restful这两个项目都要把Date类型替换掉

Resttemplate配置httpclient连接池，且要区分http调用和https调用两个template，内部调用走http，外部调用走https
httpclient连接池