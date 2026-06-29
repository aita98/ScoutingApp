@echo off
title Scout App System Launcher - FBREF Analytics

echo ============================================
echo   SCOUT APP - SYSTEM LAUNCHER (FBREF)
echo ============================================
echo.

:: ---------------------------------------------------------
:: 1) Verifica Playwright
:: ---------------------------------------------------------
echo [1/4] Verifica Ambiente Playwright...
cd /d D:\Progetti\FootballScouting\sofascore_proxy
py -m playwright install chromium

echo.

:: ---------------------------------------------------------
:: 2) Avvio Transfermarkt API (porta 8000)
:: ---------------------------------------------------------
echo [2/4] Avvio Transfermarkt API (Porta 8000)...
start "Transfermarkt API" cmd /k "cd /d D:\Progetti\FootballScouting\transfermarkt-api && set PYTHONPATH=. && py -m uvicorn app.main:app --port 8000 --host 0.0.0.0"

echo.

:: ---------------------------------------------------------
:: 3) Avvio Proxy Statistiche (Django + FBREF - Porta 9100)
:: ---------------------------------------------------------
echo [3/4] Avvio FBRef Proxy (Porta 9100)...
start "FBRef Proxy" cmd /k "cd /d D:\Progetti\FootballScouting\sofascore_proxy && py manage.py runserver 0.0.0.0:9100"

echo.

:: ---------------------------------------------------------
:: 4) Avvio Backend Spring Boot (porta 8080)
:: ---------------------------------------------------------
echo [4/4] Avvio Backend (Porta 8080)...
cd /d D:\Progetti\FootballScouting\backend
mvn spring-boot:run

pause
