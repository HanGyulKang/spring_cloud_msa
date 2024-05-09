### 대칭 키보다는 비대칭 키 사용을 권장함

---

#### RSA 키
암호화, 복호화에 각 서로 다른 키를 사용해야 함(비대칭)
* private key, public key 두 가지 키를 생성 함
* 보편적으로 private key로 암호화하고 public key로 복호화 함
* 키 생성은 JDK가 제공하는 keytool을 사용함
  * alias, name, location, country, key password, store password 등을 설정 함