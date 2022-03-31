import React, { useState } from 'react'


function BordMain() 
{
    const [inputValue, setInputValue] = useState('');

    function display( value ) {
        setInputValue( inputValue + value)
    }
    
    function clean() {
        setInputValue('')
    }

    function getResult() {
        if( inputValue.includes('=')) {
            const expresstionSplit = inputValue.split('=');
            const answer = eval(expresstionSplit.pop());
            setInputValue( inputValue + ' = ' + answer)
        }
        else {
            const answer = eval(inputValue);
            setInputValue( inputValue + ' = ' + answer)
        }
    }

    return (
        
        <div className='row justify-content-center'>
        <table className='justify-content-center'>
            <tbody>
                <tr>
                    <td colSpan={5}> 
                    <h1> Calculator with React</h1>
                    </td>
                </tr>
                <tr>
                <td colSpan={4}><input type={'text'} id={'inputArea'}  value={inputValue}/></td>
                <td><button onClick={() => {clean()}}>clean</button></td>
                </tr>
                <tr>
                <td><button onClick={() => {display('*')}}>*</button></td>
                <td><button onClick={() => {display('/')}}>/</button></td>
                <td><button onClick={() => {display('7')}}>7</button></td>
                <td><button onClick={() => {display('8')}}>8</button></td>
                <td><button onClick={() => {display('9')}}>9</button></td>
                </tr>
                <tr>
                <td><button onClick={() => {display('+')}}>+</button></td>
                <td><button onClick={() => {display('-')}}>-</button></td>
                <td><button onClick={() => {display('4')}}>4</button></td>
                <td><button onClick={() => {display('5')}}>5</button></td>
                <td><button onClick={() => {display('6')}}>6</button></td>
                </tr>
                <tr>
                <td><button onClick={() => {display('.')}}>.</button></td>
                <td><button onClick={() => {display('0')}}>0</button></td>
                <td><button onClick={() => {display('1')}}>1</button></td>
                <td><button onClick={() => {display('2')}}>2</button></td>
                <td><button onClick={() => {display('"')}}>3</button></td>
                </tr>
                <tr>
                <td colSpan={5}><button id='equal' onClick={() => { getResult()}}>=</button></td>
                </tr>
            </tbody>
            </table>
            </div>
    )
}
export default BordMain