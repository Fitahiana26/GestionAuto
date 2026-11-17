import { useState } from "react";
import axios from "axios";
import type { AuthResponse, AuthUser, LoginData, RegisterData } from "../types/Auth";
import { loginUser, registerUser } from "../services/authService";

import { setAccessToken } from "../services/apiClient";

export function errorMessage(err: unknown): string {
  if (axios.isAxiosError(err)) {
    if (err.response?.status === 401) return "Email ou mot de passe incorrect.";
    if (err.response?.status === 409) return "Cet email est déjà utilisé.";
    if (err.response?.status === 400) return "Veuillez remplir tous les champs obligatoires.";
  }
  return "Une erreur est survenue.";
}

export function useAuth() {
  const [user, setUser] = useState<AuthUser | null>(null);

  const save = (response: AuthResponse) => {
    setAccessToken(response.accessToken);
    setUser(response.user);
  };

  const login = async (data: LoginData) => save(await loginUser(data));
  const register = async (data: RegisterData) => save(await registerUser(data));

  const logout = () => {
    setAccessToken(null);
    setUser(null);
  };

  return { user, login, register, logout };
}