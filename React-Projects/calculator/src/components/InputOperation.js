import React from 'react';
import PropTypes from "prop-types";

const InputOperation = props =>
    <input
      type="text"
      className="inputField"
      value={props.operation}
    />;

InputOperation.propTypes = {
  operation: PropTypes.string.isRequired
};

export default InputOperation;
