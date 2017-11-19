import React from 'react';
import PropTypes from "prop-types";

const InputExpression = props =>
    <input
      type="text"
      className="inputField"
      value={props.expression}
    />;

InputExpression.propTypes = {
  expression: PropTypes.string.isRequired
};

export default InputExpression;
