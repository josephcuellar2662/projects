import React from 'react';
import PropTypes from "prop-types";

const OperationBtn = props =>
  <button
    className="operationBtn"
    onClick={() => props.expressionChange(props.operator)}>{props.operator}</button>;

OperationBtn.propTypes = {
  operator: PropTypes.string.isRequired,
  expressionChange: PropTypes.func.isRequired
};

export default OperationBtn;
