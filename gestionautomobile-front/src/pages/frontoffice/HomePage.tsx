import { Link, useNavigate } from "react-router-dom";
import RegisterForm from "../../components/RegisterForm";
import { useAuth } from "../../hooks/useAuth";

export default function RegisterPage() {
  const { register } = useAuth();
  const navigate = useNavigate();

  return (
    <div style={{ maxWidth: 400, margin: "0 auto" }}>
      <h2>Inscription</h2>
      <RegisterForm onSubmit={async (data) => { await register(data); navigate("/"); }} />
      <p>Déjà un compte ? <Link to="/login">Se connecter</Link></p>
    </div>
  );
}