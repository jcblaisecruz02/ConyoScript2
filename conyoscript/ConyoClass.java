//> Classes conyoscript-class
package conyoscript;

import java.util.List;
import java.util.Map;

/* Classes conyoscript-class < Classes conyoscript-class-callable
class ConyoClass {
*/
//> conyoscript-class-callable
class ConyoClass implements ConyoCallable {
//< conyoscript-class-callable
  final String name;
//> Inheritance conyoscript-class-superclass-field
  final ConyoClass superclass;
//< Inheritance conyoscript-class-superclass-field
/* Classes conyoscript-class < Classes conyoscript-class-methods

  ConyoClass(String name) {
    this.name = name;
  }
*/
//> conyoscript-class-methods
  private final Map<String, ConyoFunction> methods;

/* Classes conyoscript-class-methods < Inheritance conyoscript-class-constructor
  ConyoClass(String name, Map<String, ConyoFunction> methods) {
*/
//> Inheritance conyoscript-class-constructor
  ConyoClass(String name, ConyoClass superclass,
             Map<String, ConyoFunction> methods) {
    this.superclass = superclass;
//< Inheritance conyoscript-class-constructor
    this.name = name;
    this.methods = methods;
  }
//< conyoscript-class-methods
//> conyoscript-class-find-method
  ConyoFunction findMethod(String name) {
    if (methods.containsKey(name)) {
      return methods.get(name);
    }

//> Inheritance find-method-recurse-superclass
    if (superclass != null) {
      return superclass.findMethod(name);
    }

//< Inheritance find-method-recurse-superclass
    return null;
  }
//< conyoscript-class-find-method

  @Override
  public String toString() {
    return name;
  }
//> conyoscript-class-call-arity
  @Override
  public Object call(Interpreter interpreter, List<Object> arguments) {
    LoxInstance instance = new LoxInstance(this);
//> conyoscript-class-call-initializer
    ConyoFunction initializer = findMethod("init");
    if (initializer != null) {
      initializer.bind(instance).call(interpreter, arguments);
    }

//< conyoscript-class-call-initializer
    return instance;
  }

  @Override
  public int arity() {
/* Classes conyoscript-class-call-arity < Classes conyoscript-initializer-arity
    return 0;
*/
//> conyoscript-initializer-arity
    ConyoFunction initializer = findMethod("init");
    if (initializer == null) return 0;
    return initializer.arity();
//< conyoscript-initializer-arity
  }
//< conyoscript-class-call-arity
}
