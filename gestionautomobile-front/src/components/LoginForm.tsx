import { useState } from "react";
import { errorMessage } from "../hooks/useAuth";
import type { LoginData } from "../types/Auth";

interface Props {
  onSubmit: (data: LoginData) => Promise<void>;
}

export default function LoginForm({ onSubmit }: Props) {
  const [form, setForm] = useState<LoginData>({ email: "", password: "" });
  const [error, setError] = useState<string | null>(null);
  const [loading, setLoading] = useState(false);

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    setError(null);
    setLoading(true);
    try {
      await onSubmit(form);
    } catch (err) {
      setError(errorMessage(err));
    } finally {
      setLoading(false);
    }
  };

  return (
    <form onSubmit={handleSubmit} style={{ display: "grid", gap: 8 }}>
      <input type="email" placeholder="Email" required value={form.email}
        onChange={(e) => setForm({ ...form, email: e.target.value })} />
      <input type="password" placeholder="Mot de passe" required value={form.password}
        onChange={(e) => setForm({ ...form, password: e.target.value })} />
      {error && <p style={{ color: "red" }}>{error}</p>}
      <button type="submit" disabled={loading}>{loading ? "Connexion..." : "Se connecter"}</button>
    </form>
  );
}