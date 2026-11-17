import { Link, useNavigate } from "react-router-dom";
import LoginForm from "../../components/LoginForm";
import { useAuth } from "../../hooks/useAuth";

export default function LoginPage() {
  const { login } = useAuth();
  const navigate = useNavigate();

  return (
    <div style={{ maxWidth: 400, margin: "0 auto" }}>
      <h2>Connexion</h2>
      <LoginForm onSubmit={async (data) => { await login(data); navigate("/voitures", { replace: true }); }} />
      <p>Pas de compte ? <Link to="/register">S'inscrire</Link></p>
    </div>
  );
}