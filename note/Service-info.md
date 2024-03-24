## 구성 요소

---

| 구성요소                   | 설명                           |
|------------------------|------------------------------|
| __Git Repository__     | 마이크로서비스 소스 관리 및 프로파일 관리      |
| __Config Server__      | Git 저장소에 등록된 프로파일 정보 및 설정 정보 |
| __Eureka Server__      | 마이크로서비스 등록 및 검색              |
| __API Gateway Server__ | 마이크로서비스 부하 분산 및 서비스 라우팅      |
| __Microservices__      | 회원 MS, 주문 MS, 상품(카테고리) MS    |
| __Queuing System__     | 마이크로서비스 간 메시지 발행 및 구독        |
  
  
  
## APIs

---

| 마이크로서비스           | RESTful API                                                                                                              | HTTP Method          |
|-------------------|--------------------------------------------------------------------------------------------------------------------------|----------------------|
| __Catalog Service__ | /catalog-service/catalogs: 상품 목록 제공                                                                                      | GET                  |
| __User Service__      | /user-service/users: 사용자 정보 등록<br/>/user-service/users: 전체 사용자 조회<br/>/user-service/__{user_id}__: 사용자 정보, 주문 내역 조회<br/> | POST<br/>GET<br/>GET |
| __Order Service__     | /order-service/users/__{user_id}__/orders: 주문 등록<br/>/order-service/users/__{user_id}__: 주문 확인                      | POST<br/>GET         |