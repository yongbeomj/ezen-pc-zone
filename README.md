# EZEN PC ZONE
## contents
[0. 실행화면](https://github.com/yongbeomj/ezen-pc-zone/blob/main/README.md#0-%EC%8B%A4%ED%96%89-%ED%99%94%EB%A9%B4)  
[1. 개요](https://github.com/yongbeomj/ezen-pc-zone#1-%EA%B0%9C%EC%9A%94)  
[2. 개발일정](https://github.com/yongbeomj/ezen-pc-zone#2-%EA%B0%9C%EB%B0%9C-%EC%9D%BC%EC%A0%95)  
[3. 역할분담](https://github.com/yongbeomj/ezen-pc-zone#3-%EC%97%AD%ED%95%A0-%EB%B6%84%EB%8B%B4)  
[4. 개발환경](https://github.com/yongbeomj/ezen-pc-zone#4-%EA%B0%9C%EB%B0%9C-%ED%99%98%EA%B2%BD)  
[5. 화면 설계도](https://github.com/yongbeomj/ezen-pc-zone#5-%ED%99%94%EB%A9%B4-%EC%84%A4%EA%B3%84%EB%8F%84)  
[6. Controller 구조도](https://github.com/yongbeomj/ezen-pc-zone#6-controller-%EA%B5%AC%EC%A1%B0%EB%8F%84)  
[7. DB 구조도](https://github.com/yongbeomj/ezen-pc-zone#7-db-%EA%B5%AC%EC%A1%B0%EB%8F%84)  


## 0. 실행 화면  
![Hnet com-image](https://user-images.githubusercontent.com/87436495/142991773-99be5154-0215-4664-adf5-9802307e65e7.gif)

## 1. 개요
### 1.1. 목적
- 피시방 이용자 및 관리자의 편의성 증진

### 1.2. 프로그램 사용자
- 피시방 이용자 (손님)
- 피시방 관리자 (피시방 대표, 아르바이트생)

## 2. 개발 일정
- 기간 : 2021.11.05 ~ 2021.11.22  
- History

|날짜|내용|
|----|----|
|2021.11.05|주제 선정 <br>화면 구성 1차 논의 및 화면 구조도 작성<br>Front 초안 제작(Scenebuilder)</br>|
|2021.11.08|Logo 제작 및 논의<br>화면 구성 2차 논의<br>controller 구조도 제작</br>|
|2021.11.09|Database 설계|
|2021.11.10|Scenebuilder 화면전환 구현|
|2021.11.11|문서화(화면구조, controller 구조, DB구조)<br>Scenebuilder fx:id 명명<br>최종 역할분담 <br>Database schema 및 table 생성</br>|
|2021.11.12 ~ 2021.11.17|개인 작업|
|2021.11.18 ~ 2021.11.21|프로젝트 연결 및 오류 수정|
|2021.11.22|프로젝트 발표|

## 3. 역할 분담  
- 신우현 : Admin Project  
- 이민욱 : Kiosk Project + Admin Project(일부)
- 장용범 : Member Project  
  
## 4. 개발 환경
- 운영체제 : Windows10  
- Teck Stack : Java, Javafx, Mysql, Eclipse, SceneBuilder, Git  

## 5. 화면 설계도  
![화면 구성도](https://user-images.githubusercontent.com/87436495/142762712-17313b47-4608-425c-9294-7437abf2d847.PNG)

## 6. Controller 구조도  
### 6.1. Project : Kiosk  
![kiosk](https://user-images.githubusercontent.com/87436495/142762315-4e65330e-3ecb-44f2-a4cf-8633015ab73e.PNG)

### 6.2. Project : Admin  
![admin](https://user-images.githubusercontent.com/87436495/142762378-92cf73c5-05f9-44b3-9453-a6a155ac5840.PNG)

### 6.3. Project : Client  
![client](https://user-images.githubusercontent.com/87436495/142762387-c6fa9b56-8aa5-4e9d-b09e-cb1bcbbe68b7.PNG)

## 7. DB 구조도  
- Table : Total 7EA  
![211119_erd](https://user-images.githubusercontent.com/87436495/142559102-8652b249-c012-49e9-bef6-6fde86fbe444.png)

<!-- ## 8. 보완할 점

## 9. 느낀점 -->
