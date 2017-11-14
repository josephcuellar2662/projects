import React from 'react';
import PropTypes from "prop-types";

const EnterBtn = props =>
  <button
    className="enterBtn"
    onClick={() => props.handleOperation()}>{props.value}</button>;

EnterBtn.propTypes = {
  value: PropTypes.string.isRequired,
  handleOperation: PropTypes.func.isRequired
};

export default EnterBtn;
