import type { AuthResponse, LoginData, RegisterData } from "../types/Auth";
import { api } from "./apiClient";

const API_BASE_URL = "/api";

export const registerUser = async (payload: RegisterData): Promise<AuthResponse> => {
  const { data } = await api.post<AuthResponse>(`${API_BASE_URL}/auth/register`, payload);
  return data;
};

export const loginUser = async (payload: LoginData): Promise<AuthResponse> => {
  const { data } = await api.post<AuthResponse>(`${API_BASE_URL}/auth/login`, payload);
  return data;
};