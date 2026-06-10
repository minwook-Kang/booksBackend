-- =========================================================
-- data.sql
-- Book / Review / Feedback Mock Data
-- Entity 기준:
-- Book: id, title, author, content, genre, coverImageUrl, views, createdAt, updatedAt
-- Review: id, book_id, content, rating, likeCount, createdAt
-- Feedback: id, review_id, content, createdAt, updatedAt
--
-- DB 컬럼명은 Spring Boot 기본 naming strategy 기준:
-- coverImageUrl -> cover_image_url
-- createdAt -> created_at
-- updatedAt -> updated_at
-- likeCount -> like_count
-- =========================================================


-- =========================================================
-- BOOK DATA
-- =========================================================

INSERT INTO book
(id, title, author, content, genre, cover_image_url, views, created_at, updated_at)
VALUES
    (1, '자바의 정석', '남궁성',
     '자바의 기본 문법, 객체지향 프로그래밍, 컬렉션, 예외 처리, 스레드 등 자바 입문자가 반드시 알아야 할 내용을 단계적으로 다루는 프로그래밍 입문서입니다.',
     '프로그래밍', NULL, 152, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

    (2, '스프링 부트 입문', '김영한',
     'Spring Boot 기반 웹 애플리케이션 개발 흐름을 익히고, Controller, Service, Repository, JPA 구조를 실습 중심으로 이해할 수 있는 백엔드 개발 입문서입니다.',
     '백엔드', NULL, 98, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

    (3, '클린 코드', '로버트 C. 마틴',
     '좋은 코드와 나쁜 코드의 차이를 사례 중심으로 설명하며, 네이밍, 함수 분리, 주석, 객체 설계 등 유지보수 가능한 소프트웨어를 작성하는 원칙을 다룹니다.',
     '소프트웨어공학', NULL, 214, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

    (4, '혼자 공부하는 머신러닝+딥러닝', '박해선',
     '머신러닝과 딥러닝의 핵심 개념을 파이썬 예제와 함께 단계적으로 설명하는 AI 입문서로, 분류, 회귀, 신경망, 합성곱 신경망 등을 다룹니다.',
     '인공지능', NULL, 173, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

    (5, '모두의 데이터 분석 with 파이썬', '송석리',
     '파이썬을 활용해 데이터 수집, 전처리, 시각화, 기초 통계 분석 과정을 실습 중심으로 학습할 수 있는 데이터 분석 입문서입니다.',
     '데이터분석', NULL, 126, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

    (6, '데미안', '헤르만 헤세',
     '한 인간이 자기 자신을 찾아가는 내면의 성장 과정을 상징적으로 그려낸 고전 성장소설로, 자아와 세계의 충돌을 섬세하게 다룹니다.',
     '고전문학', NULL, 181, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

    (7, '어린 왕자', '생텍쥐페리',
     '어른이 되어 잊어버린 순수함과 관계의 의미를 짧고 아름다운 이야기로 전하는 고전 동화입니다.',
     '동화', NULL, 266, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

    (8, '불편한 편의점', '김호연',
     '서울역 인근 편의점을 배경으로 다양한 인물들의 상처와 회복을 따뜻하게 그려낸 현대 한국소설입니다.',
     '한국소설', NULL, 137, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

    (9, '채식주의자', '한강',
     '평범한 일상 속 균열을 통해 인간 내면의 폭력성, 욕망, 타인의 시선을 강렬하게 그려낸 한국문학 작품입니다.',
     '한국소설', NULL, 142, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

    (10, '달러구트 꿈 백화점', '이미예',
     '꿈을 사고파는 백화점이라는 상상력 있는 공간을 배경으로 위로와 성장의 이야기를 전하는 판타지 소설입니다.',
     '판타지', NULL, 156, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

    (11, '해리 포터와 마법사의 돌', 'J.K. 롤링',
     '마법 세계에 입문한 소년 해리 포터가 친구들과 함께 성장하고 모험을 시작하는 판타지 시리즈의 첫 번째 이야기입니다.',
     '판타지', NULL, 289, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

    (12, '셜록 홈즈의 모험', '아서 코난 도일',
     '명탐정 셜록 홈즈와 왓슨 박사가 다양한 사건을 추리하고 해결하는 고전 추리 단편집입니다.',
     '추리', NULL, 112, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

    (13, '용의자 X의 헌신', '히가시노 게이고',
     '치밀한 트릭과 인간적인 감정이 결합된 추리소설로, 범죄의 진실과 헌신의 의미를 묵직하게 그려냅니다.',
     '추리', NULL, 148, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

    (14, '사피엔스', '유발 하라리',
     '인류의 기원부터 농업혁명, 과학혁명, 현대 문명까지 거대한 흐름으로 인간의 역사를 해석한 교양서입니다.',
     '역사', NULL, 321, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

    (15, '총, 균, 쇠', '재레드 다이아몬드',
     '문명의 발전 차이를 환경, 지리, 생태적 조건의 관점에서 분석하며 인류사의 불균형을 설명하는 역사 교양서입니다.',
     '역사', NULL, 238, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

    (16, '코스모스', '칼 세이건',
     '우주, 생명, 과학적 사고의 아름다움을 문학적인 문체로 풀어낸 대표적인 과학 교양서입니다.',
     '과학', NULL, 244, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

    (17, '시간은 흐르지 않는다', '카를로 로벨리',
     '현대 물리학의 관점에서 시간의 본질을 탐구하며, 우리가 당연하게 여기는 시간 감각을 새롭게 바라보게 하는 과학 교양서입니다.',
     '과학', NULL, 91, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

    (18, '팩트풀니스', '한스 로슬링',
     '세상을 오해하게 만드는 인간의 본능을 짚고, 데이터를 통해 현실을 더 정확하게 바라보는 방법을 제시합니다.',
     '사회과학', NULL, 119, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

    (19, '미움받을 용기', '기시미 이치로',
     '아들러 심리학을 바탕으로 타인의 시선에서 벗어나 자기 삶을 선택하는 용기에 대해 대화 형식으로 설명하는 책입니다.',
     '심리학', NULL, 167, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

    (20, '죽고 싶지만 떡볶이는 먹고 싶어', '백세희',
     '일상의 우울과 불안을 솔직한 상담 기록 형식으로 풀어내며, 마음의 회복과 자기 이해를 다루는 에세이입니다.',
     '에세이', NULL, 134, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

    (21, '아주 작은 습관의 힘', '제임스 클리어',
     '작은 행동의 반복이 어떻게 큰 변화를 만들어내는지 습관 형성의 원리와 실천 방법을 중심으로 설명하는 자기계발서입니다.',
     '자기계발', NULL, 198, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

    (22, '역행자', '자청',
     '자기계발과 경제적 자유를 주제로 기존 사고방식을 바꾸고 실행력을 높이는 방법을 제시하는 책입니다.',
     '자기계발', NULL, 203, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

    (23, '돈의 속성', '김승호',
     '돈을 대하는 태도, 자산 관리, 경제적 독립에 대한 관점을 현실적인 언어로 설명하는 재테크 도서입니다.',
     '경제경영', NULL, 175, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

    (24, '넛지', '리처드 탈러',
     '사람들의 선택을 강제하지 않으면서 더 나은 방향으로 유도하는 행동경제학의 핵심 개념을 설명하는 책입니다.',
     '경제경영', NULL, 104, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

    (25, '트렌드 코리아 2026', '김난도 외',
     '소비 트렌드와 사회 변화를 분석하고 다가올 시장 흐름을 예측하는 트렌드 전망서입니다.',
     '트렌드', NULL, 87, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

    (26, '아몬드', '손원평',
     '감정을 느끼기 어려운 소년의 성장 과정을 통해 공감, 폭력, 관계의 의미를 다루는 한국 성장소설입니다.',
     '청소년문학', NULL, 161, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

    (27, '완전한 행복', '정유정',
     '행복이라는 이름 아래 감춰진 욕망과 집착을 긴장감 있게 그려낸 한국 장편소설입니다.',
     '스릴러', NULL, 93, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

    (28, '지적 대화를 위한 넓고 얕은 지식', '채사장',
     '역사, 경제, 정치, 사회, 윤리 등 다양한 분야의 기본 지식을 연결해 설명하는 교양 입문서입니다.',
     '교양', NULL, 205, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

    (29, '나는 나로 살기로 했다', '김수현',
     '타인의 기준에 흔들리지 않고 자기 삶의 태도를 세우는 법을 담은 그림 에세이입니다.',
     '에세이', NULL, 122, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

    (30, '도파민네이션', '애나 렘키',
     '쾌락과 중독, 균형의 문제를 현대 사회의 행동 패턴과 연결해 설명하는 심리·의학 교양서입니다.',
     '심리학', NULL, 116, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);


-- =========================================================
-- REVIEW DATA
-- Review Entity:
-- id, book_id, content, rating, like_count, created_at
-- Java field는 createdAt이지만 @Column(name = "created_at") 지정되어 있으므로 SQL에서는 created_at 사용
-- =========================================================

INSERT INTO review
(id, book_id, content, rating, like_count, created_at)
VALUES
    (1, 1, '자바를 처음 배우는 입장에서 문법과 객체지향 개념을 차근차근 잡기 좋았습니다. 분량은 많지만 기본기를 쌓기에는 안정적입니다.', 4.5, 12, CURRENT_TIMESTAMP),
    (2, 1, '예제가 많아서 따라 하기 좋았습니다. 다만 초반에는 설명이 길게 느껴질 수 있어 필요한 부분부터 골라 봐도 좋을 것 같습니다.', 4.0, 7, CURRENT_TIMESTAMP),
    (3, 1, '코딩테스트 준비 전에 자바 문법을 복습하기 좋았습니다. 컬렉션과 예외 처리 부분이 특히 도움이 됐습니다.', 4.2, 5, CURRENT_TIMESTAMP),

    (4, 2, 'Controller, Service, Repository 흐름을 이해하는 데 도움이 됐습니다. 백엔드 프로젝트 구조를 처음 잡는 사람에게 좋습니다.', 4.8, 15, CURRENT_TIMESTAMP),
    (5, 2, 'JPA와 API 개발을 실습하면서 익힐 수 있어서 좋았습니다. Spring Boot가 처음이라면 전체 구조를 보는 데 도움이 됩니다.', 4.6, 9, CURRENT_TIMESTAMP),
    (6, 2, '설명은 친절하지만 자바 문법을 어느 정도 알고 봐야 더 잘 이해됩니다. 완전 입문자보다는 프로젝트 시작 단계에 적합합니다.', 4.1, 3, CURRENT_TIMESTAMP),

    (7, 3, '코드를 단순히 돌아가게 만드는 것과 읽기 좋게 만드는 것은 다르다는 걸 느꼈습니다. 네이밍과 함수 분리 부분이 인상 깊었습니다.', 5.0, 24, CURRENT_TIMESTAMP),
    (8, 3, '개발 경험이 조금 쌓인 뒤 읽으니 더 와닿았습니다. 초보자보다는 팀 프로젝트를 한 번 해본 사람에게 추천합니다.', 4.7, 18, CURRENT_TIMESTAMP),
    (9, 3, '내용은 좋지만 모든 원칙을 그대로 적용하기보다는 상황에 맞게 받아들이는 게 중요하다고 느꼈습니다.', 4.3, 6, CURRENT_TIMESTAMP),

    (10, 4, '머신러닝 개념과 코드가 함께 나와서 따라가기 좋았습니다. 처음 AI를 공부할 때 부담이 적었습니다.', 4.7, 15, CURRENT_TIMESTAMP),
    (11, 4, '분류와 회귀 파트는 이해하기 쉬웠고, 딥러닝 파트는 천천히 반복해서 봐야 했습니다.', 4.3, 8, CURRENT_TIMESTAMP),
    (12, 4, '실습 중심이라 좋았지만 수학적 배경을 깊게 다루지는 않습니다. 입문용으로 적합합니다.', 4.0, 4, CURRENT_TIMESTAMP),

    (13, 5, '파이썬으로 데이터 분석을 처음 해보는 사람에게 좋습니다. 전처리와 시각화 흐름을 잡는 데 도움이 됐습니다.', 4.5, 11, CURRENT_TIMESTAMP),
    (14, 5, '실습 예제가 많아서 따라 하기 쉽습니다. 발표나 미니프로젝트 데이터 분석 준비에도 활용하기 좋았습니다.', 4.4, 6, CURRENT_TIMESTAMP),

    (15, 6, '읽을 때마다 다르게 느껴지는 책입니다. 자아와 성장에 대한 고민이 많을 때 읽으면 더 깊게 다가옵니다.', 4.8, 21, CURRENT_TIMESTAMP),
    (16, 6, '상징적인 표현이 많아서 처음에는 어렵지만 끝까지 읽고 나면 여운이 큽니다.', 4.3, 8, CURRENT_TIMESTAMP),
    (17, 6, '문장이 아름답지만 쉽게 술술 읽히는 책은 아닙니다. 천천히 곱씹으며 읽는 쪽이 좋았습니다.', 4.1, 4, CURRENT_TIMESTAMP),

    (18, 7, '짧지만 메시지가 깊습니다. 어릴 때 읽었을 때와 어른이 되어 읽었을 때 느낌이 완전히 달랐습니다.', 4.9, 30, CURRENT_TIMESTAMP),
    (19, 7, '문장이 쉽고 아름다워서 누구에게나 추천하기 좋습니다. 관계의 의미를 다시 생각하게 됩니다.', 4.7, 14, CURRENT_TIMESTAMP),
    (20, 7, '가볍게 읽기 좋지만 생각할 거리는 많았습니다. 선물용 책으로도 괜찮습니다.', 4.5, 6, CURRENT_TIMESTAMP),

    (21, 8, '편의점이라는 익숙한 공간에서 사람들의 사연이 자연스럽게 이어져 따뜻했습니다.', 4.4, 11, CURRENT_TIMESTAMP),
    (22, 8, '술술 읽히고 인물들이 정감 있습니다. 피곤할 때 부담 없이 읽기 좋은 소설입니다.', 4.2, 5, CURRENT_TIMESTAMP),
    (23, 8, '큰 사건보다는 인물의 변화와 분위기를 따라가는 책입니다. 잔잔한 이야기를 좋아하면 잘 맞습니다.', 3.9, 2, CURRENT_TIMESTAMP),

    (24, 9, '문체가 강렬하고 분위기가 독특합니다. 쉽게 읽히지만 결코 가볍지는 않은 소설입니다.', 4.5, 19, CURRENT_TIMESTAMP),
    (25, 9, '읽고 나서 불편한 감정이 남았습니다. 그래서 더 오래 기억에 남는 작품입니다.', 4.2, 9, CURRENT_TIMESTAMP),
    (26, 9, '상징과 해석의 여지가 많아서 독서모임에서 이야기하기 좋은 책이라고 느꼈습니다.', 4.4, 7, CURRENT_TIMESTAMP),

    (27, 10, '꿈을 사고파는 백화점이라는 설정이 귀엽고 따뜻했습니다. 가볍게 읽기 좋은 판타지 소설입니다.', 4.3, 12, CURRENT_TIMESTAMP),
    (28, 10, '힐링이 필요한 시기에 읽기 좋았습니다. 문장이 어렵지 않아 금방 읽을 수 있습니다.', 4.1, 5, CURRENT_TIMESTAMP),

    (29, 11, '판타지 세계관 입문작으로 완벽합니다. 다시 읽어도 캐릭터와 설정이 생생합니다.', 4.9, 40, CURRENT_TIMESTAMP),
    (30, 11, '어릴 때 읽던 느낌과 지금 읽는 느낌이 달라서 좋았습니다. 모험의 시작이라는 설렘이 있습니다.', 4.6, 13, CURRENT_TIMESTAMP),
    (31, 11, '세계관이 어렵지 않고 몰입감이 좋아서 판타지를 잘 안 읽는 사람도 접근하기 좋습니다.', 4.7, 11, CURRENT_TIMESTAMP),

    (32, 12, '짧은 사건들이 이어져 부담 없이 읽기 좋습니다. 추리소설 입문용으로 추천합니다.', 4.4, 10, CURRENT_TIMESTAMP),
    (33, 12, '홈즈와 왓슨의 관계성이 매력적입니다. 고전이지만 생각보다 지루하지 않았습니다.', 4.2, 7, CURRENT_TIMESTAMP),

    (34, 13, '트릭도 좋지만 감정선이 강하게 남는 추리소설입니다. 마지막까지 몰입해서 읽었습니다.', 4.8, 22, CURRENT_TIMESTAMP),
    (35, 13, '추리와 드라마가 잘 섞여 있습니다. 결말을 알고 나면 제목의 의미가 다르게 느껴집니다.', 4.6, 12, CURRENT_TIMESTAMP),
    (36, 13, '가볍게 읽기 시작했는데 생각보다 묵직했습니다. 추리소설을 좋아한다면 만족할 가능성이 높습니다.', 4.4, 5, CURRENT_TIMESTAMP),

    (37, 14, '인류사를 큰 흐름으로 볼 수 있어서 흥미로웠습니다. 역사, 철학, 과학이 함께 섞인 느낌입니다.', 4.8, 28, CURRENT_TIMESTAMP),
    (38, 14, '분량은 있지만 몰입감이 좋습니다. 다만 저자의 해석이 강하게 느껴지는 부분도 있습니다.', 4.4, 16, CURRENT_TIMESTAMP),
    (39, 14, '세상을 보는 관점을 넓히는 데 도움이 됐습니다. 교양서로 추천할 만합니다.', 4.6, 10, CURRENT_TIMESTAMP),

    (40, 15, '문명의 차이를 개인이나 민족의 우열이 아니라 환경 조건으로 설명하는 관점이 인상적이었습니다.', 4.7, 20, CURRENT_TIMESTAMP),
    (41, 15, '읽는 데 시간이 걸리지만 얻는 것이 많습니다. 역사와 지리에 관심 있다면 추천합니다.', 4.3, 9, CURRENT_TIMESTAMP),
    (42, 15, '초반 진입 장벽이 조금 있지만 전체 논지가 잡히면 흥미롭게 읽힙니다.', 4.0, 4, CURRENT_TIMESTAMP),

    (43, 16, '과학 교양서인데 문장이 아름답습니다. 우주에 대한 호기심을 다시 갖게 해준 책입니다.', 4.9, 33, CURRENT_TIMESTAMP),
    (44, 16, '오래된 책이지만 여전히 깊이가 있습니다. 과학을 인문학적으로 바라보게 됩니다.', 4.5, 12, CURRENT_TIMESTAMP),
    (45, 16, '천문학 지식뿐 아니라 인간과 문명에 대한 성찰이 함께 담겨 있어 좋았습니다.', 4.7, 8, CURRENT_TIMESTAMP),

    (46, 17, '시간에 대한 기존 감각을 흔드는 책입니다. 내용은 짧지만 쉽게 읽히지는 않았습니다.', 4.1, 6, CURRENT_TIMESTAMP),
    (47, 17, '물리학 배경지식이 많지 않으면 어려운 부분이 있습니다. 그래도 문장이 좋아 끝까지 읽게 됩니다.', 3.9, 3, CURRENT_TIMESTAMP),

    (48, 18, '데이터를 근거로 세상을 바라보는 태도를 배울 수 있었습니다. 막연한 비관에서 벗어나게 해줍니다.', 4.6, 14, CURRENT_TIMESTAMP),
    (49, 18, '통계와 그래프를 어렵지 않게 설명합니다. 사회 문제를 볼 때 균형 잡힌 시각이 필요하다는 걸 느꼈습니다.', 4.3, 7, CURRENT_TIMESTAMP),

    (50, 19, '타인의 평가에 흔들릴 때 읽으면 도움이 됩니다. 대화 형식이라 생각보다 읽기 편했습니다.', 4.4, 18, CURRENT_TIMESTAMP),
    (51, 19, '심리학 책이지만 자기계발서처럼 읽힙니다. 관점 전환에는 좋지만 호불호가 있을 수 있습니다.', 4.0, 6, CURRENT_TIMESTAMP),
    (52, 19, '모든 주장에 동의하지는 않았지만 인간관계를 바라보는 새로운 틀을 얻었습니다.', 3.8, 3, CURRENT_TIMESTAMP),

    (53, 20, '솔직한 상담 기록이라 공감되는 부분이 많았습니다. 가볍게 읽히지만 주제는 가볍지 않습니다.', 4.2, 9, CURRENT_TIMESTAMP),
    (54, 20, '우울과 불안을 특별한 사건이 아니라 일상 속 감정으로 다룬 점이 좋았습니다.', 4.1, 5, CURRENT_TIMESTAMP),

    (55, 21, '습관을 작게 쪼개서 실천하는 방식이 현실적이었습니다. 바로 적용할 수 있는 팁이 많습니다.', 4.7, 20, CURRENT_TIMESTAMP),
    (56, 21, '자기계발서 중에서도 실천 가능성이 높은 편입니다. 목표보다 시스템이 중요하다는 말이 기억에 남습니다.', 4.4, 9, CURRENT_TIMESTAMP),
    (57, 21, '새로운 내용이 아주 많다기보다는 알고 있던 것을 행동으로 옮기게 만드는 책입니다.', 4.0, 4, CURRENT_TIMESTAMP),

    (58, 22, '실행력과 사고방식에 대해 자극을 주는 책입니다. 자기계발서를 좋아한다면 괜찮습니다.', 4.1, 13, CURRENT_TIMESTAMP),
    (59, 22, '호불호가 있을 수 있지만, 목표를 다시 잡고 싶을 때 동기부여가 됐습니다.', 3.8, 4, CURRENT_TIMESTAMP),

    (60, 23, '돈을 단순히 버는 것보다 어떻게 대해야 하는지 생각하게 해줍니다. 재테크 초보자에게 좋습니다.', 4.5, 17, CURRENT_TIMESTAMP),
    (61, 23, '어렵지 않은 문장으로 돈에 대한 태도를 설명합니다. 실전 투자서라기보다는 관점에 가까웠습니다.', 4.2, 8, CURRENT_TIMESTAMP),
    (62, 23, '자산 관리의 기본 태도를 점검하기 좋았습니다. 가볍게 읽기 좋은 경제경영서입니다.', 4.0, 5, CURRENT_TIMESTAMP),

    (63, 24, '사람의 선택이 환경에 따라 달라질 수 있다는 점을 흥미롭게 설명합니다. 행동경제학 입문용으로 좋습니다.', 4.3, 9, CURRENT_TIMESTAMP),
    (64, 24, '사례가 많아 이해하기 쉽습니다. 정책이나 서비스 기획에 관심 있다면 도움이 됩니다.', 4.2, 6, CURRENT_TIMESTAMP),

    (65, 25, '최근 소비 흐름을 빠르게 훑어보기 좋습니다. 발표 자료나 기획 아이디어를 잡을 때 도움이 됐습니다.', 4.0, 6, CURRENT_TIMESTAMP),
    (66, 25, '트렌드 키워드를 정리하기 좋지만, 해석은 독자적으로 판단할 필요가 있습니다.', 3.8, 3, CURRENT_TIMESTAMP),

    (67, 26, '감정을 느끼기 어려운 주인공의 시선이 독특했습니다. 공감이라는 주제를 쉽게 풀어낸 소설입니다.', 4.5, 14, CURRENT_TIMESTAMP),
    (68, 26, '청소년문학이지만 어른이 읽어도 충분히 의미가 있습니다. 문장이 어렵지 않아 몰입하기 좋았습니다.', 4.3, 8, CURRENT_TIMESTAMP),

    (69, 27, '초반부터 긴장감이 있고 뒤로 갈수록 불안한 분위기가 강해집니다. 스릴러를 좋아하면 잘 맞습니다.', 4.2, 7, CURRENT_TIMESTAMP),
    (70, 27, '인물의 심리가 섬뜩하게 그려집니다. 가볍게 읽기보다는 몰입해서 읽게 되는 책입니다.', 4.1, 5, CURRENT_TIMESTAMP),

    (71, 28, '여러 분야의 기본 개념을 연결해서 볼 수 있어 좋았습니다. 교양 입문서로 무난합니다.', 4.4, 12, CURRENT_TIMESTAMP),
    (72, 28, '깊게 파고드는 책은 아니지만 전체적인 흐름을 잡기에는 좋습니다.', 4.0, 6, CURRENT_TIMESTAMP),

    (73, 29, '문장이 짧고 그림과 함께 읽혀서 부담이 적었습니다. 위로가 필요한 시기에 읽기 좋습니다.', 4.2, 10, CURRENT_TIMESTAMP),
    (74, 29, '큰 해결책을 주는 책이라기보다는 마음을 정리하게 해주는 책에 가깝습니다.', 3.9, 4, CURRENT_TIMESTAMP),

    (75, 30, '쾌락과 중독을 현대인의 생활 방식과 연결해서 설명한 점이 흥미로웠습니다.', 4.5, 13, CURRENT_TIMESTAMP),
    (76, 30, '스마트폰, 음식, 소비 습관을 돌아보게 됐습니다. 읽고 나면 생활 패턴을 점검하게 됩니다.', 4.3, 7, CURRENT_TIMESTAMP),
    (77, 30, '의학적인 내용이 있지만 어렵지 않게 풀어냅니다. 균형이라는 메시지가 좋았습니다.', 4.1, 4, CURRENT_TIMESTAMP);


-- =========================================================
-- FEEDBACK DATA
-- Feedback Entity:
-- id, review_id, content, createdAt, updatedAt
--
-- Java field는 createdAt, updatedAt이지만 기본 naming strategy 기준 SQL 컬럼명은 created_at, updated_at
-- Feedback에는 @PrePersist가 없으므로 data.sql에서 created_at, updated_at을 직접 넣음
-- Feedback은 Review와 1:1 관계이므로 review_id 중복 금지
-- 일부 Review에는 Feedback이 없음
-- =========================================================

INSERT INTO feedback
(id, review_id, content, created_at, updated_at)
VALUES
    (1, 1, '입문자 관점에서 자바 학습 난이도와 장점을 잘 설명한 리뷰입니다.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (2, 2, '분량과 학습 부담에 대한 언급이 있어 도서 선택에 참고하기 좋습니다.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (3, 4, 'Spring Boot 계층 구조를 이해하려는 독자에게 도움이 되는 리뷰입니다.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (4, 5, 'JPA와 API 실습의 장점을 함께 언급해 백엔드 학습 목적과 잘 맞습니다.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (5, 7, '클린 코드의 핵심 메시지인 가독성과 유지보수성을 잘 짚었습니다.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (6, 8, '개발 경험자에게 더 적합하다는 현실적인 판단이 포함되어 있습니다.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (7, 10, 'AI 입문 도서로서 코드와 개념을 함께 볼 수 있다는 점이 명확합니다.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (8, 13, '데이터 분석 입문자의 학습 흐름을 잘 보여주는 리뷰입니다.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (9, 15, '문학 작품의 재독 가치와 성장 서사의 의미를 잘 전달합니다.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (10, 18, '어린 왕자의 세대별 감상 차이를 잘 설명한 리뷰입니다.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (11, 21, '작품의 따뜻한 분위기와 공간적 배경을 잘 설명하고 있습니다.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (12, 24, '작품을 읽은 뒤 남는 감정과 문체의 강렬함이 잘 드러납니다.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (13, 27, '판타지 설정과 힐링 요소를 찾는 독자에게 도움이 되는 리뷰입니다.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (14, 29, '시리즈 입문작으로서의 매력과 세계관의 몰입감을 잘 보여줍니다.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (15, 32, '추리소설 입문자에게 적합하다는 점을 간결하게 전달합니다.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (16, 34, '추리와 감정선이 함께 있는 작품이라는 특징을 잘 짚었습니다.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (17, 37, '인류사를 넓은 관점에서 바라보는 책의 장점을 잘 요약했습니다.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (18, 40, '문명의 차이를 환경 조건으로 설명하는 책의 핵심 관점이 잘 드러납니다.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (19, 43, '과학 교양서의 감성적 장점과 지적 호기심을 잘 표현했습니다.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (20, 46, '시간 개념에 대한 책의 난이도와 매력을 균형 있게 설명했습니다.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (21, 48, '데이터 기반 사고라는 책의 핵심 메시지를 잘 반영한 리뷰입니다.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (22, 50, '심리적 고민이 있는 독자에게 도움이 될 수 있는 리뷰입니다.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (23, 53, '상담 기록 형식의 솔직함과 주제의 무게를 함께 언급한 점이 좋습니다.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (24, 55, '습관 형성 방법을 실천 가능성 중심으로 평가한 리뷰입니다.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (25, 58, '자기계발서 특유의 호불호 가능성을 함께 고려한 리뷰입니다.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (26, 60, '돈을 대하는 태도라는 책의 핵심을 잘 짚은 리뷰입니다.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (27, 63, '행동경제학 개념을 서비스나 정책 기획과 연결해볼 수 있는 리뷰입니다.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (28, 65, '트렌드 분석 자료를 발표나 기획에 활용할 수 있다는 점이 잘 드러납니다.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (29, 67, '공감이라는 주제를 청소년문학 관점에서 잘 설명했습니다.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (30, 69, '스릴러 장르의 긴장감과 분위기를 잘 전달하는 리뷰입니다.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (31, 71, '교양 입문서로서 넓고 얕은 지식을 연결하는 장점을 잘 설명했습니다.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (32, 73, '가볍게 읽을 수 있는 에세이의 위로 기능을 잘 보여줍니다.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (33, 75, '현대인의 습관과 도파민 문제를 연결해 설명한 점이 잘 드러납니다.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (34, 77, '책의 의학적 내용과 생활 적용 가능성을 균형 있게 평가했습니다.', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);


-- =========================================================
-- IDENTITY SEQUENCE RESET
-- 명시적으로 id를 넣었기 때문에 이후 POST 요청 시 id 중복 방지
-- H2 기준 문법
-- =========================================================

ALTER TABLE book ALTER COLUMN id RESTART WITH 31;
ALTER TABLE review ALTER COLUMN id RESTART WITH 78;
ALTER TABLE feedback ALTER COLUMN id RESTART WITH 35;