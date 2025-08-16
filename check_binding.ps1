# check_binding.ps1
Write-Host "=== 1. ��ǰģ���Ƿ��� viewBinding/dataBinding ===" -ForegroundColor Cyan
Select-String -Path "android\build.gradle" -Pattern "viewBinding|dataBinding"

Write-Host "`n=== 2. layout �ļ��� ===" -ForegroundColor Cyan
Get-ChildItem -Path "android\src\main\res\layout" -Filter "*activity_about_face_app*" -Recurse

Write-Host "`n=== 3. ���ɵ� binding ��λ�� ===" -ForegroundColor Cyan

# �ȱ���һ�Σ���Ĭ��
& ".\android\gradlew.bat" -p android assembleDebug *>$null
Get-ChildItem -Path "android\build" -Filter "*ActivityAboutFaceAppBinding*" -Recurse

Write-Host "`n=== 4. kotlin �ļ� package ===" -ForegroundColor Cyan
Get-Content "android\src\main\java\com\faceAI\demo\AboutFaceAppActivity.kt" -TotalCount 3