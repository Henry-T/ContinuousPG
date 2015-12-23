@echo off
cd %1
svn upgrade
svn revert . -R
rem 清除所有本地文件
echo clean up untracked local files
for /f "usebackq tokens=1*" %%i in (`svn status --depth infinity --no-ignore ^| findstr /r "^[\?I]"`) do ( 
  if not %%j == %~nx0 ( 
    if exist "%%j\*" ( 
      echo deleting unversioned directory "%%j" 
      attrib -h "%%j" /d /s 
      rmdir /s /q "%%j" 
    ) else ( 
      echo deleting unversioned file "%%j" 
      attrib -h "%%j" 
      del /f "%%j" 
    ) 
  )
)