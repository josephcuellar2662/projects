import React from 'react';
import PropTypes from "prop-types";

const OperationBtn = props =>
  <button
    className="operationBtn"
    onClick={() => props.operationChange(props.operator)}>{props.operator}</button>;

OperationBtn.propTypes = {
  operator: PropTypes.string.isRequired,
  operationChange: PropTypes.func.isRequired
};

export default OperationBtn;
