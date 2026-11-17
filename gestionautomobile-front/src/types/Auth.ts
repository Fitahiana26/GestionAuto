export interface AuthUser {
  id: string;
  name: string;
  firstName?: string;
  email: string;
  contact?: string;
  role?: { id: string; libelle: string };
}

export interface LoginData {
  email: string;
  password: string;
}

export interface RegisterData extends LoginData {
  name: string;
  firstName?: string;
  contact?: string;
}

export interface AuthResponse {
  accessToken: string;
  tokenType: "Bearer";
  expiresIn: number;
  user: AuthUser;
}