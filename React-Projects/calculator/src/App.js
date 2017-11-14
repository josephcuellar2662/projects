import React, { Component } from 'react';

import NumberButton from './components/NumberButton';
import OperationButton from './components/OperationButton';
import DeleteButton from './components/DeleteButton';
import ClearButton from './components/ClearButton';
import EnterButton from './components/EnterButton';
import InputOperation from './components/InputOperation';

class App extends Component {
  state = {
    operation: "",
    solution: 0
  };

  operationChange = value =>
    this.setState({
      operation: (this.state.operation+value)
    });

  clear = () =>
    this.setState({
      operation: ""
    });

  deleteLastChar = () =>
    this.setState({
      operation: this.state.operation.slice(0,-1)
    });

  handleOperation = () =>
    this.setState({
      solution: (this.state.solution+1)
    });


  render() {
    return (
      <div className="App">
        <div className="container">
          <h1>React Calculator</h1>
        </div>
        <div className="container">
          <InputOperation operation={this.state.operation}/>
        </div>
        <div className="container">
          <div className="buttons">
            <NumberButton number={7} operationChange={this.operationChange}/>
            <NumberButton number={4} operationChange={this.operationChange}/>
            <NumberButton number={1} operationChange={this.operationChange} />
            <DeleteButton value={"DEL"} handleDelete={this.deleteLastChar}/> {/* delete */}
            <NumberButton number={8} operationChange={this.operationChange}/>
            <NumberButton number={5} operationChange={this.operationChange}/>
            <NumberButton number={2} operationChange={this.operationChange}/>
            <NumberButton number={0} operationChange={this.operationChange}/>
            <NumberButton number={9} operationChange={this.operationChange}/>
            <NumberButton number={6} operationChange={this.operationChange}/>
            <NumberButton number={3} operationChange={this.operationChange}/>
            <ClearButton value={"CE"} clear={this.clear} />{/* clear */}
            <OperationButton operator={"/"} operationChange={this.operationChange}/> {/* divide */}
            <OperationButton operator={"*"} operationChange={this.operationChange}/> {/* multiply */}
            <OperationButton operator={"+"} operationChange={this.operationChange}/> {/* add */}
            <OperationButton operator={"-"} operationChange={this.operationChange}/>  {/* subtract */}
          </div>
        </div>
        <div className="container">
          <EnterButton value={"ENTER"} handleOperation={this.handleOperation} />
        </div>

      </div>
    );
  }
}

export default App;
