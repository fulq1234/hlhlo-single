**jobapp**
分析智联招聘网页的招聘信息。存入数据库。

**translation**
把一个数据库中翻译词导入另一个表中
1.在表directory中，“词汇库”的id是9，那么就是在knowledge_new中寻找typename是以9为父节点的节点，或者二级节点的id
2.knowledge_new的title是dict_en_zhcn的source
  knowledge_new的content字段需要分析
  比如“<h4>
     	入库
     </h4>
     <p>
     	<br />
     卖家正在发往仓库的货件中，该商品的数量。
     </p>”
   h4包围的内容入库就是dict_en_zhcn的tran
   其他的字符串就是放在example，注意还是html的格式。如果有图片，图片是base64编码的格式，需要保存成文件，内容src指向刚刚新建的图片文件。
**hlhlo-cloud-framework-wx**
微信客服消息

**hlhlo-cloud-jssdk**
微信的jssdk

