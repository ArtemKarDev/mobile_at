## ✅ ОСНОВНЫЕ КОМАНДЫ ЗАПУСКА

### ▶ 1. Эмулятор (локально, Wikipedia, Medium device)

```bash
./gradlew onboarding_test -DdeviceHost=emulation

```
для изменения параметра запуска

```bash
./gradlew clean test \
  "-DdeviceName=Medium Phone API 36.1" \
  -Dplatform.name=Android \
  -Dapp.package=org.wikipedia
```
