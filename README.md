## **ATMOSFER**

```Build Project```

`bash ci-cd/build.hs`

```Push Server```

`bash ci-cd/push-server.hs`

jasypt framework key:
```
-Djasypt.encryptor.password=5gArdh@8$0Z2
```
<br />

#### Jasypt Password
##### Encryption:
1. Bir encrypt key belirlenmeli
2. https://www.devglan.com/online-tools/jasypt-online-encryption-decryption -> sitesinden sifrelenmesi istenen degerlerin encrypt edilmesi.
3. Encrypt edilen degerlein config dosyasinda uygun yerlere yazilmasi(format **ENC(encryptValue)**)
4. Beilrlenen key'in baslatma komutuna eklenmesi **-Djasypt.encryptor.password=secretKey**
##### Decryption:
1. Sifrelenmis verilerin encrypt keyi bilinmeli
2. https://www.devglan.com/online-tools/jasypt-online-encryption-decryption -> sitesinden cozulmesini istenen degerler decrypt edilir.