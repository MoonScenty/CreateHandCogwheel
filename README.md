# Create: Hand Cogwheel

Minecraft 1.21.1 NeoForge 환경을 위한 소규모 Create 애드온입니다.

손 크랭크의 수동 동력 생성 기능과 톱니바퀴의 회전 전달 기능을 결합한 **손 톱니바퀴(Hand Cogwheel)**를 추가합니다.

## 주요 기능

- 블록을 우클릭하여 수동으로 회전 동력을 생성합니다.
- Create의 축과 직접 연결할 수 있습니다.
- 작은 톱니바퀴와 맞물려 회전을 전달합니다.
- 톱니바퀴와 손잡이에 회전 애니메이션이 적용됩니다.
- 축과 톱니바퀴를 바라보면 Create 스타일 설치 미리보기가 표시됩니다.
- 모든 6방향으로 설치할 수 있습니다.
- 물에 잠긴 상태를 지원합니다.
- Create 크리에이티브 모드 탭에서 아이템을 찾을 수 있습니다.
- 영어와 한국어를 지원합니다.

## 요구 사항

- Minecraft 1.21.1
- NeoForge 21.1.248 이상
- Create 6.0.10 이상, 6.1.0 미만
- Java 21

Create는 필수 선행 모드입니다. Create가 설치되지 않았거나 호환되지 않는 버전이면 모드를 불러올 수 없습니다.

## 설치 방법

1. Minecraft 1.21.1용 NeoForge를 설치합니다.
2. Create 6.0.10과 Create가 요구하는 선행 모드를 설치합니다.
3. 빌드된 Create: Hand Cogwheel JAR 파일을 게임의 `mods` 폴더에 넣습니다.
4. 게임을 실행합니다.

## 제작법

제작대 또는 인벤토리 제작 칸에서 다음 아이템을 조합합니다.

- Create 톱니바퀴 1개
- Create 손 크랭크 1개

손 톱니바퀴 1개가 만들어집니다.

## 사용 방법

손 톱니바퀴를 Create 축 끝에 설치하면 축과 직접 연결됩니다. 작은 톱니바퀴 옆에 설치하면 두 회전망이 서로 맞물립니다.

손 톱니바퀴를 든 상태에서 호환되는 축이나 톱니바퀴를 바라보면 설치 가능한 위치에 반투명 미리보기가 표시됩니다. `Shift`를 누른 상태에서는 일반 배치를 사용할 수 있습니다.

블록을 우클릭하면 손잡이가 돌아가며 일시적인 회전 동력을 공급합니다. 이 동작은 Create 손 크랭크와 동일하게 플레이어의 허기 소모량을 증가시키며, Create 서버 설정의 `crankHungerMultiplier` 값을 따릅니다.

## 아이템 명령어

`/give @s createhandcogwheel:hand_cogwheel`

## 개발 및 빌드

저장소 루트에서 다음 명령을 실행합니다.

`./gradlew build`

빌드 결과는 `build/libs/createhandcogwheel-1.0.0.jar`에 생성됩니다.

Create 개발 의존성은 [Create 공식 NeoForge 1.21.1 의존성 가이드](https://wiki.createmod.net/developers/depend-on-create/neoforge-1.21.1)를 따릅니다.

## 라이선스

이 프로젝트는 [MIT 라이선스](LICENSE)로 배포됩니다.

Create의 저작권은 Creators of Create에 있으며 별도의 라이선스로 배포됩니다. Minecraft는 Microsoft Corporation의 상표입니다. 이 프로젝트는 Mojang Studios 또는 Microsoft와 제휴하거나 보증받은 프로젝트가 아닙니다.

## 제작자

MoonScenty
