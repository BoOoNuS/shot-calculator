@echo off
echo ===========================================================================================================
echo Run command: java -jar shot.calculator-1.0-jar-with-dependencies.jar {ShotGrade} {ShotType} {CrystalCount}
echo Example of run command: java -jar shot.calculator-1.0-jar-with-dependencies.jar S spiritshot 1
echo ===========================================================================================================
echo Available shot grades - D, C, B, A, S
echo Available shot types - soulshot, spiritshot, blessed_spiritshot
echo Crystal count should be numeric (for blessed_spiritshot should be at least 2 crystal amount)
echo ===========================================================================================================

set /P shotGrade="Please enter the shot grade: "
set /P shotType="Please enter the shot type: "
set /P crystalCount="Please enter the crystal count: "
echo ===========================================================================================================

java -version
java -jar shot.calculator-1.0-jar-with-dependencies.jar %shotGrade% %shotType% %crystalCount%
pause