@echo off
tasklist /fi "imagename eq %1" | findstr %1 > nil
