import React from 'react';
import PropTypes from "prop-types";

const EnterBtn = props =>
  <button
    className="enterBtn"
    onClick={() => props.handleExpression()}>{props.value}</button>;

EnterBtn.propTypes = {
  value: PropTypes.string.isRequired,
  handleExpression: PropTypes.func.isRequired
};

export default EnterBtn;
