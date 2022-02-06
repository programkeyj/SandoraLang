#Sandora language
Sandora - интерпритируемый язык програмирования<br/>
запускающийся на  <strong>java машине</strong> <br/>
типизация минимальная<br/>

<br/>
функции записываються так:<br/>
void FuncName(arguments){ <br/>
     statements;      <br/>
}                <br/>  
if else следуйщим образом:<br/>
if(condition){<br/>
    statements;<br/>
}<br/>
else{<br/>
    statements;<br/>
}<br/>
пример кода есть в соседнем файле<br/>
запуск файла .sandora 2 пути:<br/>
java -jar SandoraApp.jar а затем внутри<br/>
приложения ввести путь к файлу, либо<br/>
java -jar SandoraApp.jar /путь к файлу/<br/>
так же присутсвует режим Debug он <br/>
показывает как лексер воспринимает строки<br/>
кода который вы запускаете. После пути добавтье<br/>
-Debug , соблюдайте регистр.<br/>
примеры: java -jar SandoraApp.jar -Debug.<br/>
or: java -jar SandoraApp.jar /path/ -Debug.

