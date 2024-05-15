# 키 생성 : Private
keytool -genkeypair -alias apiEncryptionKey -keyalg RSA -dname "CN=HanGyulKang, OU=API Development, O=spring_cloud_msa, L=Seoul, C=KR" -keypass "test1234" -keystore apiEncryptionKey.jks -storepass "test1234"
