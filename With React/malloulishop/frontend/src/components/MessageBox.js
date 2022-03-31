import React from 'react'

export default function MessageBox(props) {
  return (
    <div className={`row alert alert-${props.variant || 'info'}`}>
      <ul>
        <li>
      <img src='./images/PageNotFound.png' alt='Page Not Found'/>
        </li>
        <li>
      <p>{props.children}</p>
        </li>
      </ul>
      </div>
  )
}
