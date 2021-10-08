# Project : Get forecast from open API

<br/>

## 프로젝트 소개

[공공데이터포털](https://www.data.go.kr/), [네이버](http://openapi.naver.com), [다음](http://dna.daum.net/apis/) 등의 웹 포털에서는 **Open API**,  즉 누구나 사용할수 있도록 공개된 API를 제공합니다.

개발자들은 제공되는 API를 통해서 수많은 정보들, 예를 들면 교육, 국토관리, 공공행정, 재정금융, 산업고용, 사회복지, 식품건강, 환경기상,
법률, 과학기술, 교통 물류 등의 수많은 데이터들을 분석하고 활용하여 수많은 정보를 수집하고 분석 할 수 있습니다.

이번 프로젝트는 **Open API**를 활용해서 포털에 있는 특정 정보(환경기상)를 프로그램에서 결과를 도출 하는 것 입니다.  

<br/>



## 프로젝트 구조

- 본 프로젝트는, [공공데이터포털]( www.data.go.kr)에서 제공하는 (신)동네예보정보조회서비스 **Open API** 를 제공받아, 해당 URL 을 입력
    하고 날씨 정보를 받고 싶은 장소, 시간을 입력하여 데이터를 얻습니다.
    
- 원하는 정보를 웹서버와 교환을 하는데 있어서 효율적인 데이터 타입 중 하나인 **JSON(JavaScript Object Notation)** 을 사용하였고, 이 데이터를 **Parsing(웹상 데이터 가공)** 하여 객체로 만들었습니다.

- 단계별로 가공된 데이터를 통해 우리가 원하는 **카테고리(Key값)** 을 입력하여 원하는 **결과(Value)** 를 얻습니다.

<br/>


## 사용기술
- **JAVA**
- **Eclipse**  

<br/>



## 리뷰

많은 업종 중 개발자들은 정말 진취적인것을 느꼈습니다.

다른 업종에선 자신의 기술이 곧 자신의 자산이니 기술을 숨기는 것이 보편적인데, 개발자들은 API 혹은 코드들을 오픈하여
많은 이들에게 제공하고 또 **Open API** 혹은 **Open source** 를 본인의 방식대로 더 업그레이드 시켜서 올려 놓는 것을 보고
신기함을 느꼈습니다.

이번 프로젝트에선 **OpenAPI**를 통해 직접 서비스 키를 제공받고 프로그램에서 우리가 원하는 방식으로 **PARSING** 하는 아주 중요한 작업을 익혔습니다.

또 추후에도 많이 쓰고 있는 대표적인 자료형태 **JSON**에 대해서도 기본 개념을 익혔습니다.

우리가 원하는, 얻고자 하는 정보의 카테고리만 입력하고 파싱을하면 우리가 원하는 정보를 바로 출력 할 수 있었고
개발되어있는 웹과 앱의 구동관계에 대해 조금은 이해의 폭이 넓어진 것 같습니다.
