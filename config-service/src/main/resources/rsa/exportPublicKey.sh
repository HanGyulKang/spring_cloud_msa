# 생성된 private key로부터 퍼블릭 키 생성
keytool -export -alias apiEncryptionKey -keystore apiEncryptionKey.jks -rfc -file trustServer.cer

# 생성 이후 .cer 파일을 .jks파일로 변환
# keytool -import -alias trustServer -file trustServer.cer -keystore publicKey.jks