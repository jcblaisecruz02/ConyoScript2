# ConyoScript
ConyoScript is a lightweight scripting language that mimics how we speak on a daily basis in order to facilitate easier coding.  Make sulat code like parang how we speak, dudeparechong! 

### Syntax and Semantics
ConyoScript is very similar to JavaScript. Here is an example, inputting a number and returning its fibonacci number:

```$xslt
make_gawa fib(n) {
    if_like (n < 2) make_balik n;
    make_balik fib(n - 1) + fib(n - 2);
}

make_salita("Input a number: ");
so_like num = make_basa("%d");
make_sabi("You inputted: " + num);
make_sabi("Fibonacci of that number is: " + fib(num));
```

### Usage
Please import the .iml file as a project in IntelliJ IDEA. It should also theoretically work on a vanilla Java compiler.

### Changelog
This was a project for grad school compiler design class, so it's not maintained. Do feel free to drop by the issues tab for comments though!
