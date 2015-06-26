#Lamb
Lamb is a interpreted language that revolves around [Lambda Calculus].

Variables are made by putting the variable name, a `:` , and a value

```javascript
hello:“Hello World”
```

Functions are written in Lambda Calculus notation

```javascript
square:λx.x*x
add:λx.λy.x+y
```

Lamb is translated in JavaScript code through a Java ScriptEngine, meaning we can put JS code within our Lamb code

```javascript
power:λx.λy.Math.pow(x,y)
```

To use a function, you can call it variables or other arguments

```javascript
two:2
add(two,3)
```

You can also assign the return of a function to a variable

```javascript
h:2
h:add(h,h)
```

### Hello World

Returned values are printed out, so all we have to do is return the string “Hello World”

```javascript
"Hello World"
```

  [Lambda Calculus]: https://en.m.wikipedia.org/wiki/Lambda_calculus
