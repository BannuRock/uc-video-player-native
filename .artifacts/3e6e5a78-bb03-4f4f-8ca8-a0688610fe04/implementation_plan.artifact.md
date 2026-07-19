# Fix Espresso Dependency Resolution Error

The project fails to sync because of an incorrect artifact name for the Espresso library. The dependency `androidx.test.espresso:core:3.5.1` is being used, but the correct artifact name is `androidx.test.espresso:espresso-core:3.5.1`.

## Proposed Changes

### App Module

#### [MODIFY] [app/build.gradle](file:///C:/Users/prave/.gemini/antigravity-ide/scratch/uc-video-player-native/app/build.gradle)

The dependency name will be corrected.

```diff
-    androidTestImplementation 'androidx.test.espresso:core:3.5.1'
+    androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.1'
```

## Verification Plan

### Automated Tests
- Trigger a Gradle sync to ensure the error is resolved.
- Run a build task to confirm resolution:
  ```bash
  ./gradlew :app:assembleDebug
  ```
