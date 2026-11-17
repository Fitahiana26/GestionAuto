export interface MessageRole {
  id: string;
  libelle: string;
}

export interface MessageUser {
  id: string;
  name?: string;
  firstName?: string;
  role?: MessageRole;
}

export interface Message {
  id: string;
  message: string;
  date: string;
  user: MessageUser;
}