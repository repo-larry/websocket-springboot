创建topic
./kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic test

查看已有的topic
./kafka-topics.sh --list --bootstrap-server localhost:9092

查看topic的描述
./kafka-topics.sh --describe  --bootstrap-server localhost:9092 --topic test

删除topic
./kafka-topics.sh -delete --bootstrap-server localhost:9092 --topic test

启动生产者控制台
./kafka-console-producer.sh --bootstrap-server localhost:9092 --topic test

启动消费者控制台
./kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic test

查看topic里的数据
./kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic test --from-beginning
