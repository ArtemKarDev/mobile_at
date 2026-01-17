## ✅ ОСНОВНЫЕ КОМАНДЫ ЗАПУСКА

### ▶ 1. Эмулятор (локально, Wikipedia, Medium device)

```bash
./gradlew test -DdeviceHost=emulation
```
если хотим изменить параметры запуска

```bash
./gradlew clean test \
  -Ddevice.name=Nexus_5X \
  -Dplatform.name=Android \
  -Dapp.package=org.wikipedia
```

### ▶ 1. Реальное устройство (USB, PROD Wikipedia)
```bash
./gradlew test -DdeviceHost=real
```