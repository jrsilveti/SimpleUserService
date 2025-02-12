import { useState } from 'react';
import './App.css';

function App() {
    const [formData, setFormData] = useState({
        username: '',
        email: '',
        password: '',
    });

    const payload = {
        user_name: '',
        user_email: '',
        user_password: ''
    };

    const [errors, setErrors] = useState({
        username: '',
        email: '',
        password: '',
    });

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({
            ...formData,
            [name]: value,
        });
    };

    const validateForm = () => {
        let valid = true;
        let newErrors = { username: '', email: '', password: '' };

        if (!formData.username) {
            newErrors.username = 'Username is required.';
            valid = false;
        }
        if (!formData.email) {
            newErrors.email = 'Email is required.';
            valid = false;
        } else if (!/\S+@\S+\.\S+/.test(formData.email)) {
            newErrors.email = 'Email is invalid.';
            valid = false;
        }
        if (!formData.password) {
            newErrors.password = 'Password is required.';
            valid = false;
        }

        setErrors(newErrors);
        return valid;
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        if (validateForm()) {
            console.log('Form submitted:', formData);
            payload.user_name = formData.username;
            payload.user_email = formData.email;
            payload.user_password = formData.password;

            try {
                const response = await fetch('http://localhost:8080/users/create', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json',
                    },
                    body: JSON.stringify(payload),
                });

                if (!response.ok) {
                    throw new Error(`HTTP error! status: ${response.status}`);
                }
            } catch (error) {
                console.error('There was an error sending the data:', error);
            }

            alert('User Registered!');
        }

    };

    return (
        <>
            <h1>Welcome to the simple user service!</h1>
            <div className="card">
                <form onSubmit={handleSubmit}>
                    <div>
                        <label htmlFor="username">Username:</label>
                        <input
                            type="text"
                            id="username"
                            name="username"
                            value={formData.username}
                            onChange={handleChange}
                        />
                        {errors.username && <p className="error">{errors.username}</p>}
                    </div>
                    <div>
                        <label htmlFor="email">Email:</label>
                        <input
                            type="email"
                            id="email"
                            name="email"
                            value={formData.email}
                            onChange={handleChange}
                        />
                        {errors.email && <p className="error">{errors.email}</p>}
                    </div>
                    <div>
                        <label htmlFor="password">Password:</label>
                        <input
                            type="password"
                            id="password"
                            name="password"
                            value={formData.password}
                            onChange={handleChange}
                        />
                        {errors.password && <p className="error">{errors.password}</p>}
                    </div>
                    <button type="submit">Register</button>
                </form>
            </div>
        </>
    );
}

export default App;
