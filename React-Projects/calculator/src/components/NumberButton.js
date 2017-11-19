import React from 'react';
import PropTypes from "prop-types";

const NumberBtn = props =>
  <button
    className="numberBtn"
    onClick={() => props.expressionChange(props.number)}>{props.number}</button>;

NumberBtn.propTypes = {
  number: PropTypes.number.isRequired,
  expressionChange: PropTypes.func
};

export default NumberBtn;
