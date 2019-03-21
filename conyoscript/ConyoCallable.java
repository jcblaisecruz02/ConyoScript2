//> Functions callable
package conyoscript;

import java.util.List;

interface ConyoCallable {
//> callable-arity
  int arity();
//< callable-arity
  Object call(Interpreter interpreter, List<Object> arguments);
}
