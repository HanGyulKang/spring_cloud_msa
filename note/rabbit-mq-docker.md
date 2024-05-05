docker run -d --name rabbitmq   
-p 5672:5672   
-p 15672:15672   
-p 15692:15692   
--restart=unless-stopped   
rabbitmq:management

---

설치 후 실행.  
localhost:15672 접속 후 로그인  

| Default  | value |
|----------|-------|
| Username | Guest |
| Password | Guest |

