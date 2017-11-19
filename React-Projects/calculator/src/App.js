import React, { Component } from 'react';

import NumberButton from './components/NumberButton';
import OperationButton from './components/OperationButton';
import DeleteButton from './components/DeleteButton';
import ClearButton from './components/ClearButton';
import EnterButton from './components/EnterButton';
import InputExpression from './components/InputExpression';

class App extends Component {
  state = {
    expression: "",
    solution: "",
    postfixExpression: [],
    operators: []
  };

  expressionChange = value =>
    this.setState({
      expression: (this.state.expression+value)
    });

  addOperator = value =>
    this.setState({
      expression: (this.state.expression + ' ' + value + ' ')
  });

  clear = () =>
    this.setState({
      expression: "",
      solution: "",
      postfixExpression: [],
      operators: []
    });

  deleteLastChar = () =>
    this.setState({
      expression: this.state.expression.slice(0,-1)
    });

  handleExpression = () => {
    let opstack = [];
    let postfix = [];
    let infix = this.state.expression.split(' ');
    let index = 0;
    while(index < infix.length){
      if(!isNaN(infix[index])){
        postfix.push(infix[index]);
      }
      else {
        while(opstack.length > 0){
          let peek = opstack[opstack.length-1];
          if(precedence(peek) >= precedence(infix[index])){
            postfix.push(opstack.pop());
          } else {
            break;
          }
        }
        opstack.push(infix[index]);
      }
      index++;
    }

    while(opstack.length > 0){
       postfix.push(opstack.pop());
    }
    let solution = solvePostfixExpression(postfix);
    if(isNaN(solution)){
      solution = "Not a valid expression";
    }
    this.setState({
      postfixExpression: postfix,
      operators: opstack,
      solution: solution,
      expression: solution
    });
  }

  render() {

    return (
      <div className="App">
        <div className="container">
          <h1>React Calculator</h1>
        </div>
        <div className="container">
          <InputExpression expression={this.state.expression}/>
        </div>
        <div className="container">
          <div className="buttons">
            <NumberButton number={7} expressionChange={this.expressionChange}/>
            <NumberButton number={4} expressionChange={this.expressionChange}/>
            <NumberButton number={1} expressionChange={this.expressionChange} />
            <DeleteButton value={"DEL"} handleDelete={this.deleteLastChar}/> {/* delete */}
            <NumberButton number={8} expressionChange={this.expressionChange}/>
            <NumberButton number={5} expressionChange={this.expressionChange}/>
            <NumberButton number={2} expressionChange={this.expressionChange}/>
            <NumberButton number={0} expressionChange={this.expressionChange}/>
            <NumberButton number={9} expressionChange={this.expressionChange}/>
            <NumberButton number={6} expressionChange={this.expressionChange}/>
            <NumberButton number={3} expressionChange={this.expressionChange}/>
            <ClearButton value={"CE"} clear={this.clear} />{/* clear */}
            <OperationButton operator={'/'} expressionChange={this.addOperator}/> {/* divide */}
            <OperationButton operator={'*'} expressionChange={this.addOperator}/> {/* multiply */}
            <OperationButton operator={'+'} expressionChange={this.addOperator}/> {/* add */}
            <OperationButton operator={'-'} expressionChange={this.addOperator}/>  {/* subtract */}
          </div>
        </div>
        <div className="container">
          <EnterButton value={"ENTER"} handleExpression={this.handleExpression} />
        </div>

      </div>
    );
  }
}

function precedence (value) {
  if(value === '+' || value === '-') return 1;
  if(value === '*' || value === '/') return 2;
  return null;
}

function solvePostfixExpression(value) {
  let stack = [];
  let solution = -1;
  let index = 0;
  while(index < value.length){
    if(!isNaN(value[index])){
      stack.push(value[index]);
      console.log("push: ", value[index]);
    } else {
      if(stack.length > 1){
        let a = stack.pop();
        let b = stack.pop();
        let c = operation(value[index], b, a);
        console.log("op: ", value[index]);
        console.log("pop: ", a);
        console.log("pop: ", b);
        console.log("push: ", c);
        stack.push(c);
      } else {
        return -1;
      }
    }
    index++;
  }
  return stack.pop();
}

function operation(op, a, b){
  let a1 = parseInt(a);
  let b1 = parseInt(b);
  if(op === '+') return (a1+b1);
  else if(op === '-') return (a1-b1);
  else if(op === '/') return (a1/b1);
  else if(op === '*') return (a1*b1);
  else return null;
}

export default App;
