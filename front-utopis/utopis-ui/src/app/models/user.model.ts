export interface User {
    firstname?: string,
    lastname?: string,
    username?: string,
    email?: string,
    imageUrl?: string,
    subscription?: Subscription
}

export enum Subscription {
    FREE, PREMIUM
}